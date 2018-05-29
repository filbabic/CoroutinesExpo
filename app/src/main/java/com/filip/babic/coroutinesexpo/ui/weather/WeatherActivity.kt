package com.filip.babic.coroutinesexpo.ui.weather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.filip.babic.coroutinesexpo.R
import com.filip.babic.coroutinesexpo.di.providers.weatherPresenter
import com.filip.babic.coroutinesexpo.model.Main
import com.filip.babic.coroutinesexpo.model.Weather
import com.filip.babic.coroutinesexpo.model.Wind
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity(), WeatherView {

    private val presenter by lazy { weatherPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        presenter.setView(this)

        presenter.getWeather()
    }

    override fun showMainData(main: Main) {
        currentTemperature.text = getString(R.string.current_temperature_format, main.temperature)
        maxTemperature.text = getString(R.string.max_temperature_format, main.maxTemperature)
        minTemperature.text = getString(R.string.min_temperature_format, main.minTemperature)
        humidityPercentage.text = getString(R.string.humidity_format, main.humidity)
        currentPressure.text = getString(R.string.pressure_format, main.pressure)
    }

    override fun showWeatherData(weather: Weather) {

    }

    override fun showWindData(wind: Wind) {
        windSpeed.text = getString(R.string.wind_speed_format, wind.speed)
    }
}
