package com.rappi.mobile.movie.network.service

import com.rappi.mobile.movie.models.result.GenreResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("genre/movie/list")
    fun loadGenres(@Query("api_key") apiKey: String,
                   @Query("language") language: String): Single<GenreResult>
}
