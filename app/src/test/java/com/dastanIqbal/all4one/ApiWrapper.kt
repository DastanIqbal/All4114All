package com.dastanIqbal.all4one

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

    private fun createService(): ApiService? {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClientBuilder().build())
            .build().create(ApiService::class.java)
    }

    private fun okHttpClientBuilder(): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)

        return okHttpClientBuilder
    }

    fun getAPI(): ApiService {
        if (nytApi != null)
            return nytApi as ApiService
        nytApi = createService()
        return nytApi as ApiService
    }
}