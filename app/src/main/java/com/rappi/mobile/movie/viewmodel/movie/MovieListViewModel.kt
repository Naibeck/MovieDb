package com.rappi.mobile.movie.viewmodel.movie

import android.view.View
import androidx.databinding.ObservableInt
import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.core.BaseViewModel

class MovieListViewModel : BaseViewModel() {

    val loaderVisibility = ObservableInt(View.VISIBLE)

    fun updateViewForResult(result: MovieResult) {
        loaderVisibility.set(View.GONE)
    }

    fun updateViewForError() {
        loaderVisibility.set(View.GONE)
    }

}
