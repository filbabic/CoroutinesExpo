package com.filip.babic.coroutinesexpo.common

import com.filip.babic.coroutinesexpo.model.result.Failure
import com.filip.babic.coroutinesexpo.model.result.Mappable
import com.filip.babic.coroutinesexpo.model.result.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.experimental.suspendCoroutine

suspend fun <T : Mappable<R>, R : Any> Call<T>.awaitResult(): Result<R> {
    return suspendCoroutine { continuation ->

        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>?, error: Throwable?) {
                continuation.resume(Failure(error))
            }

            override fun onResponse(call: Call<T>?, response: Response<T>?) {
                response?.body()?.run { continuation.resume((mapToData())) }
                response?.errorBody()?.run { continuation.resume(Failure(HttpException(response))) }
            }
        })
    }
}

suspend fun <T : Mappable<R>, R : Any> Call<T>.getResult(): Result<R> {
    return suspendCoroutine { continuation ->

        try {
            val result = execute()

            result.body()?.run { continuation.resume(mapToData()) }
            result?.errorBody()?.run { continuation.resume(Failure(HttpException(result))) }
        } catch (error: Throwable) {
            continuation.resume(Failure(error))
        }
    }
}