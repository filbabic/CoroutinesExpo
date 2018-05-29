package com.filip.babic.coroutinesexpo.model

import com.filip.babic.coroutinesexpo.model.result.Failure
import com.filip.babic.coroutinesexpo.model.result.Mappable
import com.filip.babic.coroutinesexpo.model.result.Result
import com.filip.babic.coroutinesexpo.model.result.Success

data class WeatherResponse(val main: String = "",
                           val description: String = "") : Mappable<Weather> {

    override fun mapToData(): Result<Weather> = if (isValid()) {
        Success(Weather(main, description))
    } else {
        Failure(IllegalArgumentException("Weather data description is empty"))
    }

    private fun isValid() = main.isNotBlank() && description.isNotBlank()
}

data class Weather(val main: String,
                   val description: String)