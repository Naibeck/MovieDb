package com.rappi.mobile.movie.di

import android.app.Application
import android.content.Context
import com.rappi.mobile.movie.util.ResourceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    fun providesContext(): Context = application

    @Provides
    @Singleton
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)

}
