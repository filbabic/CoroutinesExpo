package com.filip.babic.coroutinesexpo.di.module.networking

import com.filip.babic.coroutinesexpo.api.WeatherApiService

interface NetworkingModule {

    val apiService: WeatherApiService
}
