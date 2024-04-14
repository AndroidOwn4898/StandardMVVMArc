package com.example.appunikinterview.network

import android.annotation.SuppressLint
import android.util.ArrayMap
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.util.*

/**
 * Converts any object to the Map<String, Any> type
 * @return Map representing key value pairs of <String, Any>
 */
fun Any?.toMap(): HashMap<String, Any> {
    this?.apply {
        val gson = Gson()
        val type = object : TypeToken<HashMap<String, Any>>() {

        }.type
        return gson.fromJson(gson.toJson(this), type)
    }
    return HashMap<String, Any>()
}

fun <T : Any> Any?.toMapOfValue(): HashMap<String, T> {
    this?.apply {
        val gson = Gson()
        val type = object : TypeToken<HashMap<String, T>>() {

        }.type
        return gson.fromJson(gson.toJson(this), type)
    }
    return HashMap<String, T>()
}
fun <T : Any> Any?.toArrayMapOfValue(): ArrayMap<String, T> {
    this?.apply {
        val gson = Gson()
        val type = object : TypeToken<ArrayMap<String, T>>() {

        }.type
        return gson.fromJson(gson.toJson(this), type)
    }
    return ArrayMap<String, T>()
}
/**
 * Converts any object to the Map<String, RequestBody> type
 * @return Map representing key value pairs of <String, RequestBody>
 */
fun Any.toRequestBodyMap(): HashMap<String, RequestBody> =
        this.toMap().mapValues {
            it.value.toString().toRequestBody()
        } as HashMap<String, RequestBody>


fun String?.toRequestBody(): RequestBody = (this ?: "").toRequestBody(MultipartBody.FORM)

@SuppressLint("DefaultLocale")
fun File.getMimeType(): String {
    val url = this.toURI().toURL().toString()
    val extension = url.substringAfterLast(".")
    when (extension.lowercase(Locale.getDefault())) {
        "jpg", "jpeg", "png" -> return "image/$extension"
        "mp4" -> return "video/$extension"
        "pdf" -> return "application/$extension"
        else -> return "image/*"
    }
}

fun File?.toMultipartBody(name: String): MultipartBody.Part? {
    this ?: return null
    return MultipartBody.Part.createFormData(
            name,
            this.name, this.asRequestBody(getMimeType().toMediaTypeOrNull())
    )
}