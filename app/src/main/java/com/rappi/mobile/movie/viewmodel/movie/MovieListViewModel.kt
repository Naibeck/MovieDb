package com.rappi.mobile.movie.viewmodel.movie

import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.models.result.MovieResult

class MovieListViewModel : ViewModel() {
    val loaderVisibility = ObservableInt(View.VISIBLE)
    val textVisibility = ObservableInt(View.GONE)
    val movieResult = ObservableField("")

    fun updateViewForResult(result: MovieResult) {
        loaderVisibility.set(View.GONE)
        textVisibility.set(View.VISIBLE)
        this.movieResult.set(result.toString())
    }

}
