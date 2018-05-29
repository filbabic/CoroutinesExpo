package com.filip.babic.coroutinesexpo.di.module.presentation

import com.filip.babic.coroutinesexpo.di.module.interaction.InteractionModule
import com.filip.babic.coroutinesexpo.di.module.interaction.InteractionModuleImpl
import com.filip.babic.coroutinesexpo.presentation.WeatherPresenter
import com.filip.babic.coroutinesexpo.presentation.WeatherPresenterImpl
import com.filip.babic.coroutinesexpo.coroutineContext.CoroutineContextProviderImpl

class PresentationModuleImpl : PresentationModule, InteractionModule by InteractionModuleImpl() {

    override fun weatherPresenter(): WeatherPresenter = WeatherPresenterImpl(weatherInteractor, CoroutineContextProviderImpl())
}