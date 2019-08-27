package com.rappi.mobile.movie.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rappi.mobile.movie.network.core.ApiClient
import com.rappi.mobile.movie.network.core.ApiClientImpl
import com.rappi.mobile.movie.network.core.ServiceGenerator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    internal fun provideApiClient(generator: ServiceGenerator): ApiClient {
        return ApiClientImpl(generator)
    }
}
