package com.filip.babic.coroutinesexpo.di.module.interaction

import com.filip.babic.coroutinesexpo.di.module.networking.NetworkingModule
import com.filip.babic.coroutinesexpo.di.module.networking.NetworkingModuleImpl
import com.filip.babic.coroutinesexpo.interaction.WeatherInteractor
import com.filip.babic.coroutinesexpo.interaction.WeatherInteractorImpl

class InteractionModuleImpl : InteractionModule, NetworkingModule by NetworkingModuleImpl() {

    override val weatherInteractor: WeatherInteractor by lazy { WeatherInteractorImpl(apiService) }
}