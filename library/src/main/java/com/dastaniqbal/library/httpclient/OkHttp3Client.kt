package com.dastaniqbal.library.httpclient

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


object OkHttp3Client {
    private var client = OkHttpClient()

    @Throws(IOException::class)
    fun run(url: String): Response {
        val request = Request.Builder()
            .url(url)
            .build()

        return client.newCall(request).execute()
    }
}