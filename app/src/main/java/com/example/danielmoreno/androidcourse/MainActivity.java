package com.example.danielmoreno.androidcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danielmoreno.androidcourse.utils.SharedPrefs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText userEditText, passwordEditText;
    private final String username = "c";
    private final String password = "c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        SharedPrefs sharedPrefs = new SharedPrefs(this);
        String userToken = sharedPrefs.getUserTokenDecrypted();
        if (userToken != null) {
            String[] userString = userToken.split(";");
            String username = userString[0];
            String password = userString[1];
                if (username.equals(this.username) && password.equals(this.password)) {
                    goToDashboard();
                }
            }
        userEditText = findViewById(R.id.usernameEditTextView);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                loginButtonClicked();
            break;
        }
    }

    private void loginButtonClicked() {
        SharedPrefs sharedPrefs = new SharedPrefs(this);
        String username = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (username.equals(this.username) && password.equals(this.password)) {
            sharedPrefs.saveUserSession(username, password);
            goToDashboard();
            return;
        }
        Toast.makeText(this, "Username or password invalid", Toast.LENGTH_LONG).show();
    }

    public void goToDashboard() {
        Intent intent = new Intent();
        intent.setClass(this, Dashboard.class);
        startActivity(intent);
        finish();
    }

}
