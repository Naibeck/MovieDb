package com.rappi.mobile.movie.network.repository

import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.network.core.ApiClient
import com.rappi.mobile.movie.network.core.ServiceGenerator
import com.rappi.mobile.movie.network.service.MovieService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiClient: ApiClient
) {

    fun loadTopMovies(page: Int = 1): Single<MovieResult> {
        return apiClient.create(MovieService::class).getTopRatedMovies(
            ServiceGenerator.API_KEY,
            ServiceGenerator.API_LANGUAGE,
            page
        )
    }

    fun loadPopularMovies(page: Int = 1): Single<MovieResult> {
        return apiClient.create(MovieService::class).getPopularMovies(
            ServiceGenerator.API_KEY,
            ServiceGenerator.API_LANGUAGE,
            page
        )
    }

    fun loadUpcomingMovies(page: Int = 1): Single<MovieResult> {
        return apiClient.create(MovieService::class).getUpcomingMovies(
            ServiceGenerator.API_KEY,
            ServiceGenerator.API_LANGUAGE,
            page
        )
    }
}
