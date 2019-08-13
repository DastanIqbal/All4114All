package com.dastaniqbal.library

import com.dastaniqbal.library.request.ImageRequest
import com.dastaniqbal.library.request.MediaType
import com.dastaniqbal.library.request.TextRequest
import org.junit.Test

class FetchUnitTest:MockServerTest()  {

    @Test
    fun fetchText() {
        Fetch.asText().eneque(
            TextRequest("http://pastebin.com/raw/wgkJgazE", MediaType.TEXT)
                .apply {
                    callback = {
                        println(it)
                    }
                }
        )
    }

    @Test
    fun fetchImage() {
        Fetch.asImage().eneque(
            ImageRequest(
                "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128&s=622a88097cf6661f84cd8942d851d9a2",
                MediaType.TEXT
            )
                .apply {
                    callback = {
                        println("W=${it.width}xH=${it.height}")
                        assert(it.width == 128 && it.height == 128)
                    }
                }
        )
    }

    fun fetchStream() {

    }
}