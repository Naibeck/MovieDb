package com.rappi.mobile.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rappi.mobile.movie.manager.GenreManager
import com.rappi.mobile.movie.manager.MovieManager
import com.rappi.mobile.movie.viewmodel.FactoryViewModel
import com.rappi.mobile.movie.viewmodel.genre.GenreViewModel
import com.rappi.mobile.movie.viewmodel.movie.MovieViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: FactoryViewModel

    private val viewModelProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(this, viewModelFactory as ViewModelProvider.Factory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MovieApp).getUiComponent().inject(this)

        val genreViewModel = viewModelProvider.get(GenreViewModel::class.java)
        val movieViewModel = viewModelProvider.get(MovieViewModel::class.java)
        genreViewModel.loadGenreList()
        movieViewModel.loadPopularMovieList()
        movieViewModel.loadTopMovieList()
        movieViewModel.loadUpcomingMovieList()
    }
}
