package com.filip.babic.coroutinesexpo.interaction

import com.filip.babic.coroutinesexpo.model.DailyWeather
import com.filip.babic.coroutinesexpo.model.result.Result

interface WeatherInteractor {

    suspend fun getWeather(cityName: String): Result<DailyWeather>
}