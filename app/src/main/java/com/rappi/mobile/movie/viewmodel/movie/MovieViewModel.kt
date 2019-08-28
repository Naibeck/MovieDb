package com.rappi.mobile.movie.viewmodel.movie

import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.manager.MovieManager
import com.rappi.mobile.movie.models.result.MovieResult
import timber.log.Timber
import javax.inject.Inject

open class MovieViewModel : ViewModel() {
    @Inject
    lateinit var movieManager: MovieManager

    fun loadPopularMovieList(resultObtained: (result: MovieResult) -> Unit) {
        movieManager.loadPopularMovies(
            success = { resultObtained(it) },
            error = { Timber.e(it) })
    }

    fun loadTopMovieList(resultObtained: (result: MovieResult) -> Unit) {
        movieManager.loadPopularMovies(
            success = { resultObtained(it) },
            error = { Timber.e(it) })
    }

    fun loadUpcomingMovieList(resultObtained: (result: MovieResult) -> Unit) {
        movieManager.loadPopularMovies(
            success = { resultObtained(it) },
            error = { Timber.e(it) })
    }

    override fun onCleared() {
        super.onCleared()
        movieManager.clear()
    }
}
