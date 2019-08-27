package com.rappi.mobile.movie.network.core

import javax.inject.Inject
import kotlin.reflect.KClass

class ApiClientImpl @Inject constructor(
    private val generator: ServiceGenerator
) : ApiClient {

    override fun <T : Any> create(service: KClass<T>): T {
        return generator.provideRetrofit().build()
            .create(service.java)
    }
}
