package com.filip.babic.coroutinesexpo.interaction

import com.filip.babic.coroutinesexpo.api.WeatherApiService
import com.filip.babic.coroutinesexpo.common.awaitResult
import com.filip.babic.coroutinesexpo.model.DailyWeather
import com.filip.babic.coroutinesexpo.model.result.Result
import kotlinx.coroutines.experimental.async

private const val API_KEY = "e7a2fb057c214c360bab5236c5948ff7"

class WeatherInteractorImpl(private val apiService: WeatherApiService) : WeatherInteractor {

    override suspend fun getWeather(cityName: String): Result<DailyWeather> =
            apiService.getWeather(cityName, API_KEY).awaitResult()
}