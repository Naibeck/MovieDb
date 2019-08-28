package com.rappi.mobile.movie.models

data class NetworkEvent<T: Any?>(val success: Boolean = false, val result: T)