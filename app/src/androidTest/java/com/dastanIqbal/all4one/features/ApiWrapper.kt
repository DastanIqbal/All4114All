package com.dastanIqbal.all4one.features

import com.dastanIqbal.network.ApiService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiWrapper {
    private val TAG = this::class.java.simpleName
    private var nytApi: ApiService? = null

    @JvmStatic
    var SERVICE_URL = "https://"
}