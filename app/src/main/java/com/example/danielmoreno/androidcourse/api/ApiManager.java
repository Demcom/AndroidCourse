package com.example.danielmoreno.androidcourse.api;

import com.example.danielmoreno.androidcourse.api.models.CurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    public static final String BASE_URL = "https://api.openweathermap.org/";
    private WeatherApiInterface weatherApiInterface;

    public ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherApiInterface = retrofit.create(WeatherApiInterface.class);
    }

    public void getWeather(Callback<CurrentWeather> callback) {
        Call<CurrentWeather> call = weatherApiInterface.getWeather("Hermosillo,mx", "be2d30db1bf3bc0b9068f424fbbd038");
        call.enqueue(callback);
    }

}
