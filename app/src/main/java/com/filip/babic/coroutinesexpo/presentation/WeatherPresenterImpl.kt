package com.filip.babic.coroutinesexpo.presentation

import com.filip.babic.coroutinesexpo.interaction.WeatherInteractor
import com.filip.babic.coroutinesexpo.model.DailyWeather
import com.filip.babic.coroutinesexpo.model.result.*
import com.filip.babic.coroutinesexpo.coroutineContext.CoroutineContextProvider
import com.filip.babic.coroutinesexpo.ui.weather.WeatherView
import kotlinx.coroutines.experimental.async

class WeatherPresenterImpl(private val weatherInteractor: WeatherInteractor,
                           private val coroutineContextProvider: CoroutineContextProvider) : WeatherPresenter {

    private lateinit var weatherView: WeatherView

    override fun setView(weatherView: WeatherView) {
        this.weatherView = weatherView
    }

    override fun getWeather() {
        async(coroutineContextProvider.main) {

            val result = weatherInteractor.getWeather("Zagreb")
            //using extensions
//            result.onSuccess { data -> showData(data) }
//                    .onError { error -> handleError(error) }

            //another way
            processResult(result)
        }
    }

    internal fun processResult(result: Result<DailyWeather>) = when (result) {
        is Success -> showData(result.data)
        is Failure -> handleError(result.error)
    }

    private fun handleError(error: Throwable?) {
        error?.printStackTrace()
    }

    internal fun showData(data: DailyWeather): Unit = with(data) {
        //do whatever with the data
        wind.onSuccess(weatherView::showWindData)
        main.onSuccess(weatherView::showMainData)

        weather.onSuccess {
            //show something
        }.onError {
            //show a placeholder maybe
        }
    }
}