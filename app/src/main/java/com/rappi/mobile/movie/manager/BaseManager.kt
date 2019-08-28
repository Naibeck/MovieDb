package com.rappi.mobile.movie.manager

import io.reactivex.disposables.CompositeDisposable

open class BaseManager {
    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    open fun clear() {
        compositeDisposable.clear()
    }
}
