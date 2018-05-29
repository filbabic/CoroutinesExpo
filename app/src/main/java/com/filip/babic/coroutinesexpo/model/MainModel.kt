package com.filip.babic.coroutinesexpo.model

import com.filip.babic.coroutinesexpo.model.result.Failure
import com.filip.babic.coroutinesexpo.model.result.Mappable
import com.filip.babic.coroutinesexpo.model.result.Result
import com.filip.babic.coroutinesexpo.model.result.Success
import com.google.gson.annotations.SerializedName

private val normalTemperatureRange = -50..60

data class MainResponse(
        @SerializedName("temp") var temperature: Float = 0f,
        @SerializedName("temp_min") var minTemperature: Float = 0f,
        @SerializedName("temp_max") var maxTemperature: Float = 0f,
        var humidity: Int = -1,
        var pressure: Float = 0f
) : Mappable<Main> {
    override fun mapToData(): Result<Main> = if (isValid()) {
        Success(Main(temperature.fromKelvinToCelsius(), minTemperature.fromKelvinToCelsius(), maxTemperature.fromKelvinToCelsius(), humidity, pressure))
    } else {
        Failure(IllegalArgumentException("Atmosphere status data is invalid"))
    }

    private fun isValid() =
            temperature.fromKelvinToCelsius() in normalTemperatureRange &&
                    minTemperature.fromKelvinToCelsius() in normalTemperatureRange &&
                    maxTemperature.fromKelvinToCelsius() in normalTemperatureRange
                    && humidity >= 0
                    && pressure > 0.0


}

fun Float.fromKelvinToCelsius(): Float = this - 273.15f


data class Main(val temperature: Float,
                val minTemperature: Float,
                val maxTemperature: Float,
                val humidity: Int,
                val pressure: Float)

