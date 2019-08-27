package com.rappi.mobile.movie.models.request

data class MovieRequest(
    val apiKey: String,
    val language: String,
    val page: Int
)
