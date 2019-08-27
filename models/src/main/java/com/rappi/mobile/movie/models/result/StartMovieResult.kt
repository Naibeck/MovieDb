package com.rappi.mobile.movie.models.result

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StartMovieResult(
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("status_message")
    val statusMessage: String,
    @SerializedName("success")
    val boolean: Boolean,
    @SerializedName("request_token")
    val requestToken: String
) : Parcelable
