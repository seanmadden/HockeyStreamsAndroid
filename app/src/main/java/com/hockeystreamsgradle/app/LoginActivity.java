package com.hockeystreamsgradle.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by sean on 2/22/15.
 */
public class LoginActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);
    }

    public void submitUserInfo(View view) {
        Intent outputData = new Intent();
        EditText username = (EditText) findViewById(R.id.loginUserName);
        EditText password = (EditText) findViewById(R.id.loginPassword);

        outputData.putExtra("username", username.getText().toString());
        outputData.putExtra("password", password.getText().toString());

        setResult(RESULT_OK, outputData);
        finish();
    }
}
