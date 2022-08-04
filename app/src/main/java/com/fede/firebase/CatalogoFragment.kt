package com.fede.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fede.firebase.adapter.PeliculaAdapter
import com.fede.firebase.databinding.FragmentCatalogoBinding
import com.fede.firebase.models.Pelicula
import com.fede.firebase.models.PeliculaResponse
import com.fede.firebase.service.APIService
import com.fede.firebase.service.APIServiceI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

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
        getPopulars{ peliculas: List<Pelicula> ->
            populares.adapter= PeliculaAdapter(peliculas)
        }
        estrenos.layoutManager= LinearLayoutManager(CatalogoFragment().context, RecyclerView.HORIZONTAL, false)
        getNowPlaying { peliculas: List<Pelicula> ->
            estrenos.adapter= PeliculaAdapter(peliculas)

        }
        m.layoutManager= LinearLayoutManager(CatalogoFragment().context, RecyclerView.HORIZONTAL, false)
        getTopRated { peliculas: List<Pelicula> ->
            m.adapter= PeliculaAdapter(peliculas)
        }
    }
    private fun getPopulars(callback: (List<Pelicula>)-> Unit){
        val apiService = APIService.getInstance().create<APIServiceI>()
        apiService.getPopular().enqueue(object : Callback<PeliculaResponse> {
            override fun onResponse(
                call: Call<PeliculaResponse>,
                response: Response<PeliculaResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<PeliculaResponse>, t: Throwable) {

            }

        })
    }
    private fun getTopRated(callback: (List<Pelicula>)-> Unit){
        val apiService = APIService.getInstance().create<APIServiceI>()
        apiService.getTopRated().enqueue(object : Callback<PeliculaResponse> {
            override fun onResponse(
                call: Call<PeliculaResponse>,
                response: Response<PeliculaResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<PeliculaResponse>, t: Throwable) {

            }

        })
    }
    private fun getNowPlaying(callback: (List<Pelicula>)-> Unit){
        val apiService = APIService.getInstance().create<APIServiceI>()
        apiService.getNowPlaying().enqueue(object : Callback<PeliculaResponse> {
            override fun onResponse(
                call: Call<PeliculaResponse>,
                response: Response<PeliculaResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<PeliculaResponse>, t: Throwable) {

            }

        })
    }
}