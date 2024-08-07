package com.example.appunikinterview.network

import android.content.Context
import com.example.appunikinterview.utils.AppConstant.IS_VALID

//Common response class for the API response
open class CommonResponse<T : Any> {
    var result: String? = null
    var message: String? = null
    var time: String? = null
    var data: T? = null


    // for Constant

 //   object AppConstant {
 //   const val APP_VERSION = "1"
//    const val IS_VALID = "1"
 //   const val STATUS_TWO = "2"
//    }

    fun isValid(context: Context? = null): Boolean {
        return when (result) {
            IS_VALID -> {
                true
            }

            else -> {
                false
            }
        }
    }

    fun mapResult(): Result<T, APIError> = if (isValid())
        Success(data)
    else
        Failure(null, APIError(code = result, message = message))
}
