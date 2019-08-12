package com.dastaniqbal.library

import com.dastaniqbal.library.core.FetchBitmap
import com.dastaniqbal.library.core.FetchFile
import com.dastaniqbal.library.core.FetchText

object Fetch {

    fun asImage(): FetchBitmap {
        return FetchBitmap()
    }

    fun asText(): FetchText {
        return FetchText()
    }

    fun asFile(): FetchFile {
        return FetchFile()
    }
}