package com.fede.firebase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fede.firebase.models.Pelicula
import com.fede.firebase.R

class PeliculaAdapter(val PeliculaList:List<Pelicula>): RecyclerView.Adapter<PeliculaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PeliculaViewHolder(layoutInflater.inflate(R.layout.item_pelicula, parent, false))
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val item = PeliculaList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =PeliculaList.size
}