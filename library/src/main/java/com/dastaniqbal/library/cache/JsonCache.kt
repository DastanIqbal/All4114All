package com.dastaniqbal.library.cache

import androidx.collection.LruCache
import java.nio.charset.Charset

class JsonCache : Cache<String> {
    private val cache: LruCache<String, String>

    init {
        val maxMemory: Long = Runtime.getRuntime().maxMemory() / 1024
        val cacheSize: Int = (maxMemory / 4).toInt()

        cache = object : LruCache<String, String>(cacheSize) {
            override fun sizeOf(key: String, value: String): Int {
                return value.toByteArray(Charset.defaultCharset()).size
            }
        }
    }

    override fun put(url: String, bitmap: String) {
        cache.put(url, bitmap)
    }

    override fun get(url: String): String? {
        return cache.get(url)
    }

    override fun clear() {
        cache.evictAll()
    }
}