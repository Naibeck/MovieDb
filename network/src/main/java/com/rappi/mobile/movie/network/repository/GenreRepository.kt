package com.rappi.mobile.movie.network.repository

import com.rappi.mobile.movie.models.result.GenreResult
import com.rappi.mobile.movie.network.core.ApiClient
import com.rappi.mobile.movie.network.core.ServiceGenerator.Companion.API_KEY
import com.rappi.mobile.movie.network.core.ServiceGenerator.Companion.API_LANGUAGE
import com.rappi.mobile.movie.network.service.GenreService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GenreRepository @Inject constructor(
    private val apiClient: ApiClient
) {

    fun loadGenres(): Single<GenreResult> = apiClient.create(GenreService::class)
                .loadGenres(API_KEY, API_LANGUAGE)
}
