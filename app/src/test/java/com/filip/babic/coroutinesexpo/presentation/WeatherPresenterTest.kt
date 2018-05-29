package com.filip.babic.coroutinesexpo.presentation

import com.filip.babic.coroutinesexpo.interaction.WeatherInteractor
import com.filip.babic.coroutinesexpo.model.DailyWeather
import com.filip.babic.coroutinesexpo.model.Main
import com.filip.babic.coroutinesexpo.model.result.Failure
import com.filip.babic.coroutinesexpo.model.result.Success
import com.filip.babic.coroutinesexpo.coroutineContext.TestCoroutineContextProviderImpl
import com.filip.babic.coroutinesexpo.ui.weather.WeatherView
import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@Suppress("RemoveRedundantBackticks")
@RunWith(MockitoJUnitRunner::class)
class WeatherPresenterTest {

    private val interactor = mock<WeatherInteractor>()
    private val weatherView = mock<WeatherView>()

    private val weatherPresenter by lazy { WeatherPresenterImpl(interactor, TestCoroutineContextProviderImpl()) }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        weatherPresenter.setView(weatherView)
    }

    @Test
    fun `getWeather shows data, backend returns a Success case`() = runBlocking {
        val main = Main(5f, 5f, 5f, 50, 5000f)
        val weather = DailyWeather(Failure(Throwable()), Success(main), Failure(Throwable()), "")

        whenever(interactor.getWeather("Zagreb")).thenReturn(Success(weather))

        weatherPresenter.getWeather()

        verify(weatherView).showMainData(any())
        verify(interactor).getWeather(any())
        verifyNoMoreInteractions(weatherView)
    }
}