package com.rappi.mobile.movie.network.service

import com.rappi.mobile.movie.models.result.StartMovieResult
import io.reactivex.Single
import retrofit2.http.POST

interface MovieAuthService {
    @POST("/auth/request_token")
    fun startRequest(): Single<StartMovieResult>
}
