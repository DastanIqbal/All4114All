package com.dastaniqbal.library.httpclient

import java.net.HttpURLConnection
import java.net.URL

class DefaultHttpClient {
    fun run(url:String){
        val url = URL(url)
        val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
        conn.inputStream
        conn.disconnect()
    }
}