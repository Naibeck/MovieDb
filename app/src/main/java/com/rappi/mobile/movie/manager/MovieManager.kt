package com.rappi.mobile.movie.manager

import com.rappi.mobile.movie.network.repository.MovieRepository
import timber.log.Timber
import javax.inject.Inject

class MovieManager @Inject constructor(
    private val movieRepository: MovieRepository
) {

    fun loadTopMovies() {
        movieRepository.loadTopMovies(
            success = {
                Timber.d(it.toString())
            },
            error = {
                Timber.e(it)
            })
    }

    fun loadPopularMovies() {
        movieRepository.loadPopularMovies(
            success = {
                Timber.d(it.toString())
            },
            error = {
                Timber.e(it)
            })
    }

    fun loadUpcomingMovies() {
        movieRepository.loadUpcomingMovies(
            success = {
                Timber.d(it.toString())
            },
            error = {
                Timber.e(it)
            })
    }

    fun onDestroy() {
        movieRepository.clearDisposable()
    }

}
