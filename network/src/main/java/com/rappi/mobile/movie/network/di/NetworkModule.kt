package com.rappi.mobile.movie.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
}
