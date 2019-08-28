package com.rappi.mobile.movie.viewmodel.movie

import androidx.lifecycle.MutableLiveData
import com.rappi.mobile.movie.manager.MovieManager
import com.rappi.mobile.movie.models.NetworkEvent
import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.core.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

open class MovieViewModel : BaseViewModel() {

    val networkNotifier = MutableLiveData<NetworkEvent<MovieResult?>>()

    @Inject
    lateinit var movieManager: MovieManager

    fun loadPopularMovieList() {
        movieManager.loadPopularMovies(
            success = { networkNotifier.value = NetworkEvent(true, it) },
            error = {
                networkNotifier.value = NetworkEvent(false, null)
                Timber.e(it)
            })
    }

    fun loadTopMovieList() {
        movieManager.loadTopMovies(
            success = { networkNotifier.value = NetworkEvent(true, it) },
            error = {
                networkNotifier.value = NetworkEvent(false, null)
                Timber.e(it)
            })
    }

    fun loadUpcomingMovieList() {
        movieManager.loadUpcomingMovies(
            success = { networkNotifier.value = NetworkEvent(true, it) },
            error = {
                networkNotifier.value = NetworkEvent(false, null)
                Timber.e(it)
            })
    }

    override fun onCleared() {
        super.onCleared()
        movieManager.clear()
    }
}
