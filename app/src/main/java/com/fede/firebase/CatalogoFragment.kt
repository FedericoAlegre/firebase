package com.fede.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.fede.firebase.adapter.PeliculaAdapter
import com.fede.firebase.databinding.FragmentCatalogoBinding

class CatalogoFragment : Fragment(R.layout.fragment_catalogo) {
    private lateinit var binding: FragmentCatalogoBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalogo, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatalogoBinding.bind(view)
        initRecyclerView()
        //val populares = binding.populares

    }
    fun initRecyclerView(){
        val populares = binding.populares
        val estrenos = binding.estrenos
        val m = binding.masPeliculas
        populares.layoutManager= LinearLayoutManager(CatalogoFragment().context, RecyclerView.HORIZONTAL, false)
        populares.adapter= PeliculaAdapter(PeliculasProvider.peliculaList)
        estrenos.layoutManager= LinearLayoutManager(CatalogoFragment().context, RecyclerView.HORIZONTAL, false)
        estrenos.adapter= PeliculaAdapter(PeliculasProvider.peliculaList)
        m.layoutManager= LinearLayoutManager(CatalogoFragment().context, RecyclerView.HORIZONTAL, false)
        m.adapter= PeliculaAdapter(PeliculasProvider.peliculaList)
    }
}