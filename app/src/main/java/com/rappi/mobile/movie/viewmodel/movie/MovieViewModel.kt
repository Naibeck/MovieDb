package com.rappi.mobile.movie.viewmodel.movie

import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.manager.MovieManager
import timber.log.Timber
import javax.inject.Inject

open class MovieViewModel : ViewModel() {
    @Inject
    lateinit var movieManager: MovieManager

    fun loadPopularMovieList() {
        movieManager.loadPopularMovies(
            success = { Timber.d(it.toString()) },
            error = { Timber.e(it) })
    }

    fun loadTopMovieList() {
        movieManager.loadPopularMovies(
            success = { Timber.d(it.toString()) },
            error = { Timber.e(it) })
    }

    fun loadUpcomingMovieList() {
        movieManager.loadPopularMovies(
            success = { Timber.d(it.toString()) },
            error = { Timber.e(it) })
    }

    override fun onCleared() {
        super.onCleared()
        movieManager.clear()
    }
}
