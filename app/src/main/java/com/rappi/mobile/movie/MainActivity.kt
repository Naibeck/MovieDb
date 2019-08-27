package com.rappi.mobile.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rappi.mobile.movie.manager.GenreManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var genreManager: GenreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MovieApp).getUiComponent().inject(this)

        genreManager.loadGenres()
    }

    override fun onDestroy() {
        super.onDestroy()
        genreManager.onDestroy()
    }
}
