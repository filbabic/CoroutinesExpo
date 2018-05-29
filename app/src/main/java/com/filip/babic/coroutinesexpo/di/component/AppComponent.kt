package com.filip.babic.coroutinesexpo.di.component

import com.filip.babic.coroutinesexpo.presentation.WeatherPresenter

interface AppComponent {

    fun weatherPresenter(): WeatherPresenter
}