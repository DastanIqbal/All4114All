package com.dastaniqbal.library.core

import com.dastaniqbal.library.request.FileRequest
import okhttp3.ResponseBody
import java.io.InputStream

class FetchFile : AbstractFetch<InputStream>() {

    fun eneque(request: FileRequest) {
        executorService.submit {
            val body = fetch(request.murl)
            uiHandler.post {
                request.callback?.invoke(fetchStream(body!!))
            }
        }
    }


    private fun fetchStream(body: ResponseBody): InputStream {
        return body.byteStream()
    }
}