package com.dastaniqbal.library.core

import com.dastaniqbal.library.cache.TextCache
import com.dastaniqbal.library.request.TextRequest
import okhttp3.ResponseBody

class FetchText : AbstractFetch<String>() {

    init {
        cache = TextCache()
    }

    fun eneque(request: TextRequest) {
        var cached = cache?.get(request.murl)
        if (cached != null) {
            request.callback?.invoke(cached)
        }
        executorService.submit {
            val body = fetch(request.murl)
            cached = fetchText(body)

            this.cache?.put(request.murl, cached!!)
            uiHandler.post {
                request.callback?.invoke(cached!!)
            }
        }
    }

    private fun fetchText(body: ResponseBody?): String? {
        return body?.string()
    }
}