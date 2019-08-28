package com.rappi.mobile.movie.network.core

import android.content.Context
import android.net.ConnectivityManager
import timber.log.Timber
import javax.inject.Inject

class NetworkUtil @Inject constructor(
    private val context: Context
) {

    fun isConnected(): Boolean {
        return try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            activeNetwork != null && activeNetwork.isConnected
        } catch (exception: Exception) {
            Timber.e(exception.message)
            true
        }
    }

}
