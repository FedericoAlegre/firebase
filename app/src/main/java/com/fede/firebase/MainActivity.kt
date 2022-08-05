package com.fede.firebase

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fede.firebase.models.User


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController

        MyToolbar().show(this, "Home", false)



        loadFragment(CatalogoFragment())
        val user = intent.getParcelableExtra<User>(LoginActivity.INTENT_PARCELABLE)

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.itemUser) {
            val bundle = Bundle()
            val user=intent.getParcelableExtra<User>("OBJECT_INTENT")
            bundle.putParcelable("DATA", user)
            val fragment = ProfileFragment()
            fragment.arguments =  bundle
            loadFragment(fragment)
        }
        return super.onOptionsItemSelected(item)
    }
}