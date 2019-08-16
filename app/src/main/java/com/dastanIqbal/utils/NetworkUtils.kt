@file:JvmName("NetworkUtils")

package com.dastanIqbal.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

fun isConnectingToInternet(context: Context): Boolean {
    val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = connectivity.allNetworkInfo
    for (i in info.indices)
        if (info[i].state == NetworkInfo.State.CONNECTED) {
            return true
        }
    return false
}

fun hasInternet(context: Context, success: () -> Unit, failed: (() -> Unit)? = null) {
    if (isConnectingToInternet(context)) {
        success()
    } else {
        failed?.invoke()
        Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show()
    }
}