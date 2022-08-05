package com.fede.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fede.firebase.databinding.FragmentMovieBinding
import com.fede.firebase.models.Pelicula


class MovieFragment : Fragment() {

    private lateinit var binding:FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        val args = this.arguments
        val data = args?.getParcelable<Pelicula>("OBJECT_INTENT")

        val back = binding.ivBackground

        val imageBase = "https://image.tmdb.org/t/p/w500/"
        Glide.with(back.context).load(imageBase+data?.backdropPath).into(back)
        val poster = binding.ivDetailsPoster
        Glide.with(poster.context).load(imageBase+data?.poster).into(poster)
        val title = binding.tvDetailsTitle
        title.text=data?.title
        val overview = binding.tvDetailsOverview
        overview.text=data?.overview
        val release = binding.tvDetailsRelease
        release.text = data?.release

    }


}