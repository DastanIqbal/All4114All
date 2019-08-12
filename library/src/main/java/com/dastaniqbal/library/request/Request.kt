package com.dastaniqbal.library.request

import android.graphics.Bitmap
import com.dastaniqbal.library.utils.md5
import java.io.InputStream

enum class MediaType {
    IMAGE, TEXT, FILE
}

abstract class Request<T>(var murl: String, var mtype: MediaType) {
    var id = murl.md5()
    var callback: ((data: T) -> Unit)? = null
}

class ImageRequest(url: String, type: MediaType) : Request<Bitmap>(url, type)

class TextRequest(url: String, type: MediaType) : Request<String>(url, type)

class FileRequest(url: String, type: MediaType) : Request<InputStream>(url, type)