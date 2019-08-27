package com.rappi.mobile.movie.models.result

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResult(
    @SerializedName("page")
    val currentPage: Int,
    @SerializedName("results")
    val movieResult: List<MovieItemResult>
) : Parcelable