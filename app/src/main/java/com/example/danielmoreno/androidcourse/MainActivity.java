package com.example.danielmoreno.androidcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danielmoreno.androidcourse.utils.SharedPreferencesHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText userEditText, passwordEditText;
    private final String username = "c";
    private final String password = "c";
    private SharedPreferencesHelper mSharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mSharedPreferencesHelper = new SharedPreferencesHelper(this);
        if (mSharedPreferencesHelper.isUserLoggedIn()) {
            goToDashboard();
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
        String username = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (username.equals(this.username) && password.equals(this.password)) {
            mSharedPreferencesHelper.persistUserSession(username, password);
            goToDashboard();
            return;
        }
        Toast.makeText(this, "Username or password invalid", Toast.LENGTH_LONG).show();
    }

    private void goToDashboard() {
        Intent intent = new Intent();
        intent.setClass(this, Dashboard.class);
        startActivity(intent);
        finish();
    }

}
