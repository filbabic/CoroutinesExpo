package com.filip.babic.coroutinesexpo.di.module.networking

import com.filip.babic.coroutinesexpo.BuildConfig
import com.filip.babic.coroutinesexpo.api.WeatherApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingModuleImpl : NetworkingModule {

    private val baseUrl: String = "http://api.openweathermap.org/"

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
            }
        }.build()
    }

    private val converterFactory : GsonConverterFactory by lazy { GsonConverterFactory.create() }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(converterFactory)
                .build()
    }

    override val apiService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}