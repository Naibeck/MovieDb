package com.rappi.mobile.movie.util

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.rappi.mobile.movie.models.result.MovieItemResult
import com.rappi.mobile.movie.movie.MovieDetailActivity
import javax.inject.Inject

class NavigationUtil @Inject constructor() {

    fun navigateToMovieDetail(
        fragment: Fragment,
        movieItem: MovieItemResult
    ) {
        val intent = Intent(fragment.context, MovieDetailActivity::class.java)
        intent.putExtra(MOVIE_ITEM_EXTRA, movieItem)
        fragment.startActivity(intent)
    }

    companion object {
        const val MOVIE_ITEM_EXTRA = "movie.item.extra"
    }

}
