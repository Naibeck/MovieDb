package com.rappi.mobile.movie.models.result

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreResult(
    @SerializedName("genres")
    val genres: List<GenreItemResult>
) : Parcelable