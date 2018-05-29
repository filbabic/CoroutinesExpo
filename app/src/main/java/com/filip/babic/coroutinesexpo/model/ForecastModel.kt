package com.filip.babic.coroutinesexpo.model

data class ForecastResponse(var list: List<DailyWeatherResponse> = listOf())

data class Forecast(val dailyList : List<Weather>)