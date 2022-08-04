package com.fede.firebase.service


import com.fede.firebase.models.PeliculaResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIServiceI {
    @GET("movie/popular?api_key=0fed6cae2938bd52048f89173bb9e056&page=1")
    fun getPopular(): Call<PeliculaResponse>
    @GET("movie/top_rated?api_key=0fed6cae2938bd52048f89173bb9e056&page=1")
    fun getTopRated(): Call<PeliculaResponse>
    @GET("movie/now_playing?api_key=0fed6cae2938bd52048f89173bb9e056&page=1")
    fun getNowPlaying(): Call<PeliculaResponse>

}