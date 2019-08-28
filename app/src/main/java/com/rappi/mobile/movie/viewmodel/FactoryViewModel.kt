package com.rappi.mobile.movie.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rappi.mobile.movie.MovieApp
import com.rappi.mobile.movie.viewmodel.genre.GenreViewModel
import com.rappi.mobile.movie.viewmodel.movie.MovieViewModel

class FactoryViewModel(private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    fun inject(viewModel: ViewModel?) {
        viewModel?.let { injectModel(it) }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return injectModel(modelClass.newInstance())
    }

    private fun <T> injectModel(viewModel: T): T {
        val injector = (application as MovieApp).getUiComponent()
        when (viewModel) {
            is GenreViewModel -> injector.inject(viewModel)
            is MovieViewModel -> injector.inject(viewModel)
        }
        return viewModel
    }

}
