package com.dastaniqbal.library.core

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.dastaniqbal.library.cache.MemoryCache
import com.dastaniqbal.library.request.ImageRequest
import okhttp3.ResponseBody

class FetchBitmap : AbstractFetch<Bitmap>() {

    init {
        cache = MemoryCache()
    }

    fun eneque(request: ImageRequest) {
        var cached = cache?.get(request.murl)
        if (cached != null) {
            request.callback?.invoke(cached)
        }
        executorService.submit {
            val body = fetch(request.murl)
            cached = fetchBitmap(body!!)

            this.cache?.put(request.murl, cached!!)

            uiHandler.post {
                request.callback?.invoke(cached!!)
            }
        }
    }


    private fun fetchBitmap(body: ResponseBody): Bitmap {
        return BitmapFactory.decodeStream(body.byteStream())
    }
}