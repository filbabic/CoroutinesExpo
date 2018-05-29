package com.filip.babic.coroutinesexpo.di.module.presentation

import com.filip.babic.coroutinesexpo.presentation.WeatherPresenter

interface PresentationModule {

    fun weatherPresenter(): WeatherPresenter
}