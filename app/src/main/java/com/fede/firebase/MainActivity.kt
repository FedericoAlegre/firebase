package com.fede.firebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fede.firebase.adapter.PeliculaAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(CatalogoFragment())



    }




    /*fun initRecyclerView(){
        val populares = findViewById<RecyclerView>(R.id.populares)
        populares.layoutManager= LinearLayoutManager(CatalogoFragment().context)
        populares.adapter= PeliculaAdapter(PeliculasProvider.peliculaList)
    }*/

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}