package com.filip.babic.coroutinesexpo.ui.weather

import com.filip.babic.coroutinesexpo.model.Main
import com.filip.babic.coroutinesexpo.model.Weather
import com.filip.babic.coroutinesexpo.model.Wind

interface WeatherView {

    fun showMainData(main: Main)

    fun showWindData(wind: Wind)

    fun showWeatherData(weather: Weather)
}