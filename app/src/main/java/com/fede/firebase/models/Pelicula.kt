package com.fede.firebase.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pelicula (
    @SerializedName("id")
    val id:String?,
    @SerializedName("title")
    val  title: String?,
    @SerializedName("poster_path")
    val poster: String?,
    @SerializedName("release_date")
    val release:String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("overview")
    val overview:String?
    ): Parcelable{
        constructor(): this("","","","", "","")

    }