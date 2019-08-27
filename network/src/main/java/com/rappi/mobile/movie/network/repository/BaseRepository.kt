package com.rappi.mobile.movie.network.repository

import io.reactivex.disposables.CompositeDisposable

abstract class BaseRepository {
    internal val compositeDisposable by lazy {
        CompositeDisposable()
    }

    /**
     * Call this method to provide life cycle aware and avoid memory leaks
     */
    fun clearDisposable() {
        compositeDisposable.clear()
    }
}
