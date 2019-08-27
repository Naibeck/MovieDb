package com.rappi.mobile.movie.di.component

import com.rappi.mobile.movie.MainActivity
import com.rappi.mobile.movie.di.AppModule
import com.rappi.mobile.movie.network.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface UiComponent {

    fun inject(activity: MainActivity)

}
