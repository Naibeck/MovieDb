package com.rappi.mobile.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.rappi.mobile.movie.databinding.ActivityMainBinding
import com.rappi.mobile.movie.manager.GenreManager
import com.rappi.mobile.movie.manager.MovieManager
import com.rappi.mobile.movie.movie.MoviePagerAdapter
import com.rappi.mobile.movie.util.ResourceProvider
import com.rappi.mobile.movie.viewmodel.FactoryViewModel
import com.rappi.mobile.movie.viewmodel.genre.GenreViewModel
import com.rappi.mobile.movie.viewmodel.movie.MovieViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: FactoryViewModel

    @Inject
    lateinit var resourceProvider: ResourceProvider

    private val viewModelProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(this, viewModelFactory as ViewModelProvider.Factory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as MovieApp).getUiComponent().inject(this)

        binding.apply {
            movieContainer.adapter = MoviePagerAdapter(resourceProvider, supportFragmentManager)
            movieTab.setupWithViewPager(movieContainer)
        }

        val genreViewModel = viewModelProvider.get(GenreViewModel::class.java)
        genreViewModel.loadGenreList()
    }
}
