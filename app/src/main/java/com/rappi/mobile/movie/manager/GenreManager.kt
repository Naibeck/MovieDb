package com.rappi.mobile.movie.manager

import com.rappi.mobile.movie.models.result.GenreResult
import com.rappi.mobile.movie.network.repository.GenreRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GenreManager @Inject constructor(
    private val genresRepository: GenreRepository
) : BaseManager() {

    fun loadGenres(
        success: (result: GenreResult) -> Unit,
        error: (error: Throwable) -> Unit
    ) {
        compositeDisposable.add(
            genresRepository.loadGenres().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) }
                )
        )
    }
}
