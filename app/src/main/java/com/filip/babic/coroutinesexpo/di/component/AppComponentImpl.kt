package com.filip.babic.coroutinesexpo.di.component

import com.filip.babic.coroutinesexpo.di.module.presentation.PresentationModule
import com.filip.babic.coroutinesexpo.di.module.presentation.PresentationModuleImpl

class AppComponentImpl : AppComponent, PresentationModule by PresentationModuleImpl()