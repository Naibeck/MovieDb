package com.rappi.mobile.movie.network.core

import kotlin.reflect.KClass

interface ApiClient {
    fun <T: Any>create(service: KClass<T>): T
}
