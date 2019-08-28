package com.rappi.mobile.movie.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rappi.mobile.movie.R
import com.rappi.mobile.movie.util.ResourceProvider

class MoviePagerAdapter(
    private val resourceProvider: ResourceProvider,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    private val movieTabs = resourceProvider.getArrayString(R.array.movie_tabs)

    override fun getItem(position: Int): Fragment {
        return when (movieTabs[position]) {
            TOP -> MovieListFragment.newInstance(MovieListFragment.MOVIE_TOP)
            UPCOMING -> MovieListFragment.newInstance(MovieListFragment.MOVIE_UPCOMING)
            POPULAR -> MovieListFragment.newInstance(MovieListFragment.MOVIE_POPULAR)
            else -> MovieListFragment.newInstance("")
        }
    }

    override fun getPageTitle(position: Int) = movieTabs[position]

    override fun getCount() = movieTabs.size

    companion object {
        private const val TOP = "Top"
        private const val UPCOMING = "Upcoming"
        private const val POPULAR = "Popular"
    }
}
