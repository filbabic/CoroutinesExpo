package com.filip.babic.coroutinesexpo.di.module.interaction

import com.filip.babic.coroutinesexpo.interaction.WeatherInteractor

interface InteractionModule {

    val weatherInteractor: WeatherInteractor
}