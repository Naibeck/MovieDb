package com.rappi.mobile.movie.network.service

import com.rappi.mobile.movie.models.result.MovieResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") languageCode: String,
        @Query("page") page: Int): Single<MovieResult>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") languageCode: String,
        @Query("page") page: Int): Single<MovieResult>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") languageCode: String,
        @Query("page") page: Int): Single<MovieResult>
}
