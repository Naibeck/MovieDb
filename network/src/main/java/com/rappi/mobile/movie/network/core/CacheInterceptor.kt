package com.rappi.mobile.movie.network.core

import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(
    private val networkUtil: NetworkUtil
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = if (networkUtil.isConnected()) {
            request.newBuilder().header(CACHE_NAME, CACHE_VALUE).build()
        } else {
            request.newBuilder().header(CACHE_NAME, CACHE_STORE_VALUE).build()
        }
        return chain.proceed(request)
    }

    companion object {
        private const val VALID_TIME = 15
        private const val CACHE_NAME = "Cache-Control"
        private const val CACHE_VALUE = "public, max-age=$VALID_TIME"
        private const val CACHE_STORE_VALUE = "\"public, only-if-cached, max-stale=${60 * 60 * 24 * 7}"
    }
}
