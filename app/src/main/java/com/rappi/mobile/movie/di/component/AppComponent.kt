package com.rappi.mobile.movie.di.component

import android.content.Context
import com.rappi.mobile.movie.di.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun provideContext(): Context

}
