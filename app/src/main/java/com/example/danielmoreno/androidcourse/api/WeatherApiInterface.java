package com.example.danielmoreno.androidcourse.api;

import com.example.danielmoreno.androidcourse.api.models.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

    @GET("/data/2.5/weather")
    Call<CurrentWeather> getWeather(@Query("q") String city, @Query("appid") String appId);

}

