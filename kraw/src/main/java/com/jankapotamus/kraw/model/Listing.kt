package com.jankapotamus.kraw.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Listing(
    @SerializedName("kind") val kind: String
): Parcelable