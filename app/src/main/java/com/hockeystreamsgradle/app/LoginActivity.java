package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hockeystreamsgradle.api.APIWrapper;
import com.hockeystreamsgradle.api.LoginResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sean on 2/22/15.
 */
public class LoginActivity extends Activity{

    private final APIWrapper api = APIWrapper.getInstance();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);
        context = this;
    }

    public void submitUserInfo(View view) {
        final Intent outputData = new Intent();
        final EditText username = (EditText) findViewById(R.id.loginUserName);
        final EditText password = (EditText) findViewById(R.id.loginPassword);

        final TextView tview = (TextView) findViewById(R.id.pageTitle);
        tview.setText("Logging in...");

        api.login(username.getText().toString(), password.getText().toString(), new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                tview.setText("Success...");
                outputData.putExtra("TextInfo", "Welcome " + loginResponse.getUsername());
                outputData.putExtra("AuthToken", loginResponse.getToken());
                setResult(RESULT_OK, outputData);
                finish();
            }

            @Override
            public void failure(RetrofitError error) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Login Failed");
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tview.setText("Login Page");
                    }
                });
                AlertDialog aDialog = builder.create();
                aDialog.show();
            }
        });

    }
}
