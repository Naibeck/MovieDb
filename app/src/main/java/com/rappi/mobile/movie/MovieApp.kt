package com.rappi.mobile.movie

import android.app.Application
import com.rappi.mobile.movie.di.DaggerWrapper
import com.rappi.mobile.movie.di.component.UiComponent
import com.rappi.mobile.movie.extension.unless
import timber.log.Timber

class MovieApp : Application() {

    private lateinit var daggerWrapper: DaggerWrapper

    override fun onCreate() {
        super.onCreate()
        unless(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        daggerWrapper = DaggerWrapper(this)
    }

    fun getUiComponent(): UiComponent = daggerWrapper.uiModule
}
