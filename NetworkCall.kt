package com.example.appunikinterview.network

import android.util.Log
import retrofit2.Call
import retrofit2.awaitResponse

/**
 * This extension method enqueues the call using the coroutine and
 * return the Result instance with Success or Failure
 */
suspend fun <T : Any> Call<T>.getResult(): Result<T, APIError> {
    return try {
        val response = this@getResult.awaitResponse()
        if (response.isSuccessful) {
            if (response.code() == 201) {
                val apiError = APIError("", "201", 201, null)
                Failure(null, apiError)
            } else {
                Success(response.body())
            }
        } else {
            //parse error from API
            when (response.code()) {
                401 -> {
                    val apiError = APIErrorUtils.parseError<T, APIError>(response)
                    apiError?.status_code = 401
                    Failure(null, apiError)
                }
                500 -> {
                    val apiError = APIErrorUtils.parseError<T, APIError>(response)
                    apiError?.status_code = 500
                    Failure(null, apiError)
                }
                else -> {
                    val apiError = APIErrorUtils.parseError<T, APIError>(response)
                    Failure(null, apiError)
                }
            }
        }
    } catch (throwable: Throwable) {
        Log.e("","getRepoListResource: ", throwable)
        Failure(throwable, APIError(null, "500", 500, null))
    }
}






