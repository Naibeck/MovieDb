package com.rappi.mobile.movie.viewmodel.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.manager.MovieManager
import com.rappi.mobile.movie.models.NetworkEvent
import com.rappi.mobile.movie.models.result.MovieResult
import timber.log.Timber
import javax.inject.Inject

open class MovieViewModel : ViewModel() {

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

    fun loadTopMovieList(resultObtained: (result: MovieResult) -> Unit) {
        movieManager.loadTopMovies(
            success = { networkNotifier.value = NetworkEvent(true, it) },
            error = {
                networkNotifier.value = NetworkEvent(false, null)
                Timber.e(it)
            })
    }

    fun loadUpcomingMovieList(resultObtained: (result: MovieResult) -> Unit) {
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
