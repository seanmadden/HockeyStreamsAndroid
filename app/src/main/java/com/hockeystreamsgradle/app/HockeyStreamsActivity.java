package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.hockeystreamsgradle.api.APIWrapper;
import com.hockeystreamsgradle.api.GetLiveResponse;
import com.hockeystreamsgradle.api.LoginResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Activity for the hockey streams viewer
 */
public class HockeyStreamsActivity extends Activity {
    public static final int LOGIN_ACTIVITY = 1;
    public static final String AUTH_TOKEN = "AUTH_TOKEN";
    private final APIWrapper api = APIWrapper.getInstance();
    private Context context;
    private String username;
    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = this;

        loadAuthToken();

        final List<String> actions = new ArrayList<String>();
        actions.add("Login");
        actions.add("Live stream");
        actions.add("On demand");

        final ArrayAdapter<String>
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, actions.toArray(new String[actions.size()]));

        final ListView actionList = (ListView) findViewById(R.id.actionList);
        actionList.setAdapter(adapter);
        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView selectedItem = (TextView) view;

                if ((selectedItem.getText().equals("Login"))) {
                    final Intent intent = new Intent(context, LoginActivity.class);
                    startActivityForResult(intent, LOGIN_ACTIVITY);

                } else if ((selectedItem).getText().equals("Live stream")) {
                    api.getLive(new Callback<GetLiveResponse>() {
                        @Override
                        public void success(GetLiveResponse getLiveResponse, Response response) {
                            if (getLiveResponse.getStatus().equals("Success")) {
                                final Intent intent = new Intent(context, ChooseLiveGameActivity.class);
                                intent.putExtra("schedule", (Serializable) getLiveResponse.getSchedule());
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            //TODO
                            System.out.println("asf");
                            System.out.println("asf");
                        }
                    });
                }
            }
        });
    }

    private void loadAuthToken() {
        final SharedPreferences prefs = getSharedPreferences("HockeyStreamsPreferences", MODE_PRIVATE);
        final String token = prefs.getString(AUTH_TOKEN, null);
        if (token != null) {
            api.setToken(token);
        }
    }

    private void storeAuthToken(final String token) {
        final SharedPreferences prefs = getSharedPreferences("HockeyStreamsPreferences", MODE_PRIVATE);
        Editor editor = prefs.edit();
        editor.putString(AUTH_TOKEN, token);
        editor.apply();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == LOGIN_ACTIVITY) {
            //TODO: null checks, etc
            username = intent.getExtras().get("username").toString();
            password = intent.getExtras().get("password").toString();

            api.login(username, password, new Callback<LoginResponse>() {
                @Override
                public void success(LoginResponse loginResponse, Response response) {
                    TextView tv = (TextView) findViewById(R.id.textInfo);
                    tv.setText("Login was successful!");
                    storeAuthToken(loginResponse.getToken());
                }

                @Override
                public void failure(RetrofitError error) {
                }
            });
        }
    }


}
