package com.rappi.mobile.movie.extension

/**
 * Inline function that will execute the block only if the condition is met.
 * It will reduce cases for single ifs
 */
inline fun unless(condition: Boolean, executable: () -> Unit) {
    if (condition) executable.invoke()
}