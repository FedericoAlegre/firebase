package com.fede.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fede.firebase.databinding.FragmentMovieBinding
import com.fede.firebase.databinding.FragmentProfileBinding
import com.fede.firebase.models.Pelicula
import com.fede.firebase.models.User


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        binding = FragmentProfileBinding.bind(view)

        val args = this.arguments
        val data =  args?.getParcelable<User>("DATA")

        val profile = binding.profilePhoto
        val userName = binding.profileName
        //algun dia
        //Glide.with(profile.context).load(data?.profile).into(profile)
        Glide.with(profile.context).load(R.drawable.ic_launcher_foreground).into(profile)
        userName.text = data?.name+ " "+data?.last


        return view
    }
}