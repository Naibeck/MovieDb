package com.rappi.mobile.movie

import android.app.Application
import com.rappi.mobile.movie.extensions.unless
import timber.log.Timber

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        unless(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
