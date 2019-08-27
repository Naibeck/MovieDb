package com.rappi.mobile.movie.network.repository

import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.network.core.ApiClient
import com.rappi.mobile.movie.network.core.ServiceGenerator
import com.rappi.mobile.movie.network.service.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiClient: ApiClient
) : BaseRepository() {

    fun loadTopMovies(
        success: (result: MovieResult) -> Unit,
        error: (error: Throwable) -> Unit,
        page: Int = 1
    ) {
        compositeDisposable.add(
            apiClient.create(MovieService::class).getTopRatedMovies(
                ServiceGenerator.API_KEY,
                ServiceGenerator.API_LANGUAGE,
                page
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) }
                )
        )
    }

    fun loadPopularMovies(
        success: (result: MovieResult) -> Unit,
        error: (error: Throwable) -> Unit,
        page: Int = 1
    ) {
        compositeDisposable.add(
            apiClient.create(MovieService::class).getPopularMovies(
                ServiceGenerator.API_KEY,
                ServiceGenerator.API_LANGUAGE,
                page
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) }
                )
        )
    }

    fun loadUpcomingMovies(
        success: (result: MovieResult) -> Unit,
        error: (error: Throwable) -> Unit,
        page: Int = 1
    ) {
        compositeDisposable.add(
            apiClient.create(MovieService::class).getUpcomingMovies(
                ServiceGenerator.API_KEY,
                ServiceGenerator.API_LANGUAGE,
                page
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) }
                )
        )
    }
}
