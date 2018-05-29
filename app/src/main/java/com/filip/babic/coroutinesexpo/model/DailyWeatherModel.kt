package com.filip.babic.coroutinesexpo.model

import com.filip.babic.coroutinesexpo.model.result.*
import com.google.gson.annotations.SerializedName

data class DailyWeatherResponse(
        val weather: List<WeatherResponse> = listOf(),
        @SerializedName("main") private val mainResponse: MainResponse = MainResponse(),
        @SerializedName("wind") private val windResponse: WindResponse = WindResponse(),
        @SerializedName("name") private val cityName: String = ""
) : Mappable<DailyWeather> {
    override fun mapToData(): Result<DailyWeather> = if (isValid()) {
        Success(mapToDailyWeather())
    } else {
        Failure(IllegalArgumentException("Weather data is not present"))
    }

    private fun mapToDailyWeather(): DailyWeather = DailyWeather(
            weather[0].mapToData(),
            mainResponse.mapToData(),
            windResponse.mapToData(),
            cityName
    )

    private fun isValid() = weather.isNotEmpty()
}

data class DailyWeather(val weather: Result<Weather>,
                        val main: Result<Main>,
                        val wind: Result<Wind>,
                        val cityName: String)