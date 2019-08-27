package com.rappi.mobile.movie.models.result

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieItemResult(
    @SerializedName("popularity")
    val popularityRate: Double,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("video")
    val hasVideo: Boolean,
    @SerializedName("vote_average")
    val voteRate: Double,
    @SerializedName("title")
    val name: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genre_ids")
    val genres: List<Int>,
    @SerializedName("adult")
    val isForAdultsOnly: Boolean,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster")
    val posterImage: String,
    @SerializedName("backdrop_path")
    val backgroundImage: String
) : Parcelable
