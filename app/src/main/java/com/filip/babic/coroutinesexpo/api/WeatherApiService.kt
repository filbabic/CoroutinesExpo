package com.filip.babic.coroutinesexpo.api

import com.filip.babic.coroutinesexpo.model.DailyWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("/data/2.5/weather")
    fun getWeather(@Query("q") cityName: String, @Query("appid") apiKey: String): Call<DailyWeatherResponse>
}