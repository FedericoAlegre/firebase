package com.fede.firebase.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fede.firebase.models.Pelicula
import com.fede.firebase.R

class PeliculaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val imageBase="https://image.tmdb.org/t/p/w500/"
    val pelicula = view.findViewById<TextView>(R.id.tvPeliculaTitulo)
    val peliculaPoster = view.findViewById<ImageView>(R.id.ivPeliculaPoster)
    fun render(peliculaModel: Pelicula){
        pelicula.text=peliculaModel.title
        Glide.with(peliculaPoster.context).load(imageBase+peliculaModel.poster).into(peliculaPoster)
    }

}