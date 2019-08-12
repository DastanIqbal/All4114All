package com.dastaniqbal.library.cache

interface Cache<T> {
    fun put(url: String, value: T)
    fun get(url: String): T?
    fun clear()
}