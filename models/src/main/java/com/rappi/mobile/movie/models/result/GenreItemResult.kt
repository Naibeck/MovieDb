package com.rappi.mobile.movie.models.result

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreItemResult(
    @SerializedName("id")
    val genreId: Int,
    @SerializedName("name")
    val name: String
) : Parcelable
