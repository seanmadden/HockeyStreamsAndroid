package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.hockeystreamsgradle.api.HockeyStreamsAPI;
import com.hockeystreamsgradle.api.LoginBody;
import com.hockeystreamsgradle.api.LoginResponse;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 2/22/15.
 */
public class HockeyStreamsActivity extends Activity {
    protected final String TAG = "HS";
    private final String API_KEY = "17601b27272c619c8c1a0469794c5bf3";
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = this;

        final List<String> actions = new ArrayList<String>();
        actions.add("Login");
        actions.add("Live stream");
        actions.add("On demand");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, actions.toArray(new String[actions.size()]));

        final ListView actionList = (ListView) findViewById(R.id.actionList);
        actionList.setAdapter(adapter);
        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView selectedItem = (TextView) view;

                if ((selectedItem.getText().equals("Login"))) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        final TextView tv = (TextView) findViewById(R.id.textInfo);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.hockeystreams.com")
                .build();

        HockeyStreamsAPI api = restAdapter.create(HockeyStreamsAPI.class);
        EditText loginField = (EditText) findViewById(R.id.loginUserName);
        EditText passwordField = (EditText) findViewById(R.id.loginPassword);

        try {
            api.login(loginField.getText().toString(),
                    passwordField.getText().toString(),
                    API_KEY,
                    new Callback<LoginResponse>() {
                        @Override
                        public void success(LoginResponse json, Response response) {
                            tv.setText(json.getFavteam());
                            Log.i(TAG, "S FROM CALLBACK: " + json);
                            Log.i(TAG, response.getBody().toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            tv.setText("Failure");
                            Log.e(TAG, error.toString());
                        }
                    });
        } catch (Exception e) {
            Log.i(TAG, "ERROR: ", e);
        }

    }


}
