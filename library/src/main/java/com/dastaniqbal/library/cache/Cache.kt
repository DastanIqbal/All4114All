package com.dastaniqbal.library.cache

interface Cache<T> {
    fun put(url: String, bitmap: T)
    fun get(url: String): T?
    fun clear()
}