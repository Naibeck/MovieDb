package com.rappi.mobile.movie.manager

import com.rappi.mobile.movie.network.repository.GenreRepository
import timber.log.Timber
import javax.inject.Inject

class GenreManager @Inject constructor(
    private val genresRepository: GenreRepository
) {

    fun loadGenres() {
        genresRepository.loadGenres(
            success = {
                Timber.d(it.toString())
            },
            error = {
                Timber.e(it)
            })
    }

    fun onDestroy() {
        genresRepository.clearDisposable()
    }
}
