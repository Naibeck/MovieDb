package com.rappi.mobile.movie.extensions

/**
 *
 */
inline fun unless(condition: Boolean, executable: () -> Unit) {
    if (condition) executable.invoke()
}