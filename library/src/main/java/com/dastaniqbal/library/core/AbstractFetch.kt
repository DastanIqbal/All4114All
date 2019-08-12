package com.dastaniqbal.library.core

import android.os.Handler
import android.os.Looper
import com.dastaniqbal.library.cache.Cache
import com.dastaniqbal.library.httpclient.OkHttp3Client
import okhttp3.ResponseBody
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

open class AbstractFetch<T> {
    var cache: Cache<T>? = null
    internal var executorService: ExecutorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    internal val uiHandler: Handler = Handler(Looper.getMainLooper())

    fun clearCache() {
        cache?.clear()
    }

    internal fun fetch(url: String): ResponseBody? {
        var result: ResponseBody? = null
        try {
            val response = OkHttp3Client.run(url)
            result = response.body
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }
}