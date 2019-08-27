package com.rappi.mobile.movie.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelModule(
    @SerializedName("status_code")
    private val statusCode: Int,
    @SerializedName("status_message")
    private val statusMessage: String,
    @SerializedName("success")
    private val success: Boolean,
    @SerializedName("request_token")
    private val requestToken: String
) : Parcelable
