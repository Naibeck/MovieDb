package com.rappi.mobile.movie.viewmodel.movie

import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.util.NavigationUtil
import javax.inject.Inject

class MovieListViewModel : ViewModel() {

    @Inject
    lateinit var navigationUtil: NavigationUtil

    val loaderVisibility = ObservableInt(View.VISIBLE)

    fun updateViewForResult(result: MovieResult) {
        loaderVisibility.set(View.GONE)
    }

    fun updateViewForError() {
        loaderVisibility.set(View.GONE)
    }

}
