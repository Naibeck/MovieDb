package com.rappi.mobile.movie.network.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rappi.mobile.movie.network.core.*
import com.rappi.mobile.network.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    internal fun provideClientBuilder(
        context: Context,
        networkUtil: NetworkUtil
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .addInterceptor(CacheInterceptor(networkUtil))
            .cache(getCache(context))

    }

    @Provides
    internal fun providesNetworkUtil(context: Context): NetworkUtil {
        return NetworkUtil(context)
    }

    @Provides
    internal fun provideApiClient(generator: ServiceGenerator): ApiClient {
        return ApiClientImpl(generator)
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }

    private fun getCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }
}
