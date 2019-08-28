package com.rappi.mobile.movie.manager

import com.rappi.mobile.movie.models.result.MovieResult
import com.rappi.mobile.movie.network.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieManager @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseManager() {

    fun loadTopMovies(
        success: (result: MovieResult) -> Unit,
        error: (error: Throwable) -> Unit
    ) {
        compositeDisposable.add(
            movieRepository.loadTopMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) })
        )
    }

    fun loadPopularMovies(
        success: (result: MovieResult) -> Unit,
        error: (error: Throwable) -> Unit
    ) {
        compositeDisposable.add(
            movieRepository.loadPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) })
        )
    }

    fun loadUpcomingMovies(
        success: (result: MovieResult) -> Unit,
        error: (error: Throwable) -> Unit
    ) {
        compositeDisposable.add(
            movieRepository.loadUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> success(result) },
                    { error -> error(error) })
        )
    }
}
