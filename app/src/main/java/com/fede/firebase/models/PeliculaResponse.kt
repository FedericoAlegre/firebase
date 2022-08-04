package com.fede.firebase.models

import com.google.android.gms.common.util.CollectionUtils.listOf
import android.os.Parcelable
import com.fede.firebase.models.Pelicula
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class PeliculaResponse(
    @SerializedName("results")
    val movies : List<Pelicula>
):Parcelable{
    constructor():this(listOf())
}