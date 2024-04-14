package com.example.appunikinterview.network

import android.os.Build
import com.example.appunikinterview.network.resources.ApiInterface
import com.example.appunikinterview.utils.AppConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    lateinit var retrofit: Retrofit

    val service: ApiInterface by lazy {
        val builder = Retrofit.Builder()
            .baseUrl(Helper.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val client = OkHttpClient.Builder()
        client.connectTimeout(60, TimeUnit.SECONDS)
        client.readTimeout(60, TimeUnit.SECONDS)
        client.writeTimeout(60, TimeUnit.SECONDS)

        /**
         * Interceptor will intercept the request before it send to the server
         * Hereby it will add Authorization and BarerToken in header for security reason
         * Every time it will generate new random string and new encrypted token
         * */
        val interceptor = Interceptor {
            var request = it.request()
            try {
                val newBuilder = request.newBuilder()

                newBuilder.addHeader(
                    "device_model",
                    "${Build.MANUFACTURER} ${Build.MODEL} - ${Build.VERSION.SDK_INT}"
                )
                newBuilder.addHeader("device_app_version", AppConstant.APP_VERSION)
                newBuilder.addHeader("country_code", "IN")
                newBuilder.addHeader("device_type", "Android")
                newBuilder.addHeader("language_id", "1")
                request = newBuilder.build()
            } catch (_: Exception) {
            }
            val response = it.proceed(request)
            response
        }
        client.addInterceptor(interceptor)
        /**
         * End of interceptor code
         * */


      /*  if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(loggingInterceptor)
        }*/

        builder.client(client.build())
        retrofit = builder.build()
        retrofit.create(ApiInterface::class.java)
    }
}