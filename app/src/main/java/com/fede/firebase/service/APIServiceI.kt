package com.fede.firebase.service


import com.fede.firebase.models.PeliculaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServiceI {
    @GET
    fun getMovieList(@Url url:String): Call<PeliculaResponse>
}