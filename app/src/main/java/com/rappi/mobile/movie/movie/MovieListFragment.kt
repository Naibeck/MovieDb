package com.rappi.mobile.movie.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.rappi.mobile.movie.MovieApp
import com.rappi.mobile.movie.R
import com.rappi.mobile.movie.core.BaseFragment
import com.rappi.mobile.movie.databinding.FragmentMovieListBinding
import com.rappi.mobile.movie.models.NetworkEvent
import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.viewmodel.FactoryViewModel
import com.rappi.mobile.movie.viewmodel.movie.MovieListViewModel
import com.rappi.mobile.movie.viewmodel.movie.MovieViewModel
import javax.inject.Inject

class MovieListFragment : BaseFragment() {

    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: FragmentMovieListBinding

    private val networkObserver by lazy {
        Observer<NetworkEvent<MovieResult?>> { networkEvent ->
            when {
                networkEvent.success -> networkEvent.result?.let { result ->
                    binding.movieCollection.adapter = MovieItemAdapter(result.movieResult) { item ->
                        movieListViewModel.navigationUtil.navigateToMovieDetail(
                            this@MovieListFragment,
                            item
                        )
                    }
                    movieListViewModel.updateViewForResult(result)
                }
                else -> {
                    movieListViewModel.updateViewForError()
                    Toast.makeText(context, "An error occurred fetching movies", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as MovieApp).getUiComponent().inject(this)
        movieListViewModel = getViewModel(MovieListViewModel::class.java)
        movieViewModel = getViewModel(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            when (it.getString(MOVIE_TYPE)) {
                MOVIE_POPULAR -> {
                    movieViewModel.loadPopularMovieList()
                }
                MOVIE_TOP -> {
                    movieViewModel.loadTopMovieList()
                }
                MOVIE_UPCOMING -> {
                    movieViewModel.loadUpcomingMovieList()
                }
            }
        }
        binding.apply {
            listViewModel = movieListViewModel
            context?.let {
                movieCollection.layoutManager =
                    GridLayoutManager(it, it.resources.getInteger(R.integer.span_count))
            }
        }
        loadObservers()
    }

    private fun loadObservers() {
        movieViewModel.networkNotifier.observe(this, networkObserver)
    }

    private fun updateMovie(result: MovieResult) {
        movieListViewModel.updateViewForResult(result)
    }

    companion object {
        fun newInstance(movieType: String): MovieListFragment {
            val bundle = Bundle()
            bundle.putString(MOVIE_TYPE, movieType)
            val fragment = MovieListFragment()
            fragment.arguments = bundle
            return fragment
        }

        const val MOVIE_TYPE = "movie.type"
        const val MOVIE_POPULAR = "movie.popular"
        const val MOVIE_TOP = "movie.top"
        const val MOVIE_UPCOMING = "movie.upcoming"
    }
}
