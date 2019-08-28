package com.rappi.mobile.movie.viewmodel.genre

import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.manager.GenreManager
import timber.log.Timber
import javax.inject.Inject

class GenreViewModel : ViewModel() {

    @Inject
    lateinit var genreManager: GenreManager

    fun loadGenreList() {
        genreManager.loadGenres(
            success = { Timber.d("Genres loaded") },
            error = { Timber.e(it) })
    }

    override fun onCleared() {
        super.onCleared()
        genreManager.clear()
    }
}
