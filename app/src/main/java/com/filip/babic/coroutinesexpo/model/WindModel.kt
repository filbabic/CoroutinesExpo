package com.filip.babic.coroutinesexpo.model

import com.filip.babic.coroutinesexpo.model.result.Failure
import com.filip.babic.coroutinesexpo.model.result.Mappable
import com.filip.babic.coroutinesexpo.model.result.Result
import com.filip.babic.coroutinesexpo.model.result.Success
import com.google.gson.annotations.SerializedName

data class WindResponse(var speed: Double = 0.0) : Mappable<Wind> {
    override fun mapToData(): Result<Wind> = if (isValid()) {
        Success(Wind(speed))
    } else {
        Failure(IllegalArgumentException("Wind data is invalid"))
    }

    private fun isValid() = speed >= 0.0
}

data class Wind(val speed: Double)