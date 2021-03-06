package com.rappi.mobile.movie.util

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import javax.inject.Inject
import javax.inject.Singleton

class ResourceProvider @Inject constructor(
    private val context: Context
) {

    internal fun getString(@StringRes stringRes: Int): String {
        return context.getString(stringRes)
    }

    internal fun getArrayString(@ArrayRes arrayRes: Int): Array<String> {
        return context.resources.getStringArray(arrayRes)
    }
}
