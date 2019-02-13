package com.example.danielmoreno.androidcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danielmoreno.androidcourse.api.ApiManager;
import com.example.danielmoreno.androidcourse.api.models.CurrentWeather;
import com.example.danielmoreno.androidcourse.utils.SharedPreferencesHelper;
import com.example.danielmoreno.androidcourse.contacts.ContactsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private static final Double ABSOLUTE_ZERO = 273.15;
    private TextView mWeatherTextView;
    private CardView mLogoutCardView;
    private CardView mContactsCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mLogoutCardView = findViewById(R.id.logoutCarView);
        mWeatherTextView = findViewById(R.id.weatherLabel);
        mLogoutCardView.setOnClickListener(this);
        mContactsCardView = findViewById(R.id.contactsCardView);
        mContactsCardView.setOnClickListener(this);
        ApiManager apiManager = new ApiManager();
        apiManager.getWeather(new Callback<CurrentWeather>() {
            @Override
                public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.isSuccessful()) {
                    CurrentWeather currentWeather = response.body();
                    Double celsius = currentWeather.getMain().getTemp() - ABSOLUTE_ZERO;
                    String fullTemperature = String.format("%s%s%s", String.valueOf(celsius.intValue()), "° ", currentWeather.getWeather().get(0).getMain());
                    mWeatherTextView.setText(fullTemperature);
                    Log.d("RESPONSE", currentWeather.getName());
                } else {
                    Toast.makeText(getApplicationContext(), "There was an error.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logoutCarView) {
            logoutUser();
        } else if (v.getId() == R.id.contactsCardView) {
            Intent intent = new Intent();
            intent.setClass(this, ContactsActivity.class);
            startActivity(intent);
        }
    }

    private void logoutUser() {
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(this);
        sharedPreferencesHelper.logoutUser();
        goToLogin();
    }

    private void goToLogin() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }
}
