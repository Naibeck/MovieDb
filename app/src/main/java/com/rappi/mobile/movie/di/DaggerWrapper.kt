package com.rappi.mobile.movie.di

import android.app.Application
import com.rappi.mobile.movie.di.component.DaggerUiComponent
import com.rappi.mobile.movie.di.component.UiComponent
import com.rappi.mobile.movie.network.di.NetworkModule

class DaggerWrapper(private val application: Application) {

    val uiModule: UiComponent

    init {
        val appModule = AppModule(application)
        val networkModule = NetworkModule()
        uiModule = DaggerUiComponent.builder()
            .appModule(appModule)
            .networkModule(networkModule)
            .build()

    }

}
