package com.filip.babic.coroutinesexpo

import android.app.Application
import com.filip.babic.coroutinesexpo.di.component.AppComponent
import com.filip.babic.coroutinesexpo.di.component.AppComponentImpl

class App : Application() {

    companion object {
        val appComponent: AppComponent by lazy { AppComponentImpl() }
    }

    override fun onCreate() {
        super.onCreate()

        //init our component
        appComponent
    }
}