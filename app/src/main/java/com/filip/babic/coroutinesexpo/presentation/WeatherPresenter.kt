package com.filip.babic.coroutinesexpo.presentation

import com.filip.babic.coroutinesexpo.ui.weather.WeatherView

interface WeatherPresenter {

    fun setView(weatherView: WeatherView)

    fun getWeather()
}