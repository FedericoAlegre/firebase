package com.fede.firebase

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MyToolbar {
    fun show(activities: AppCompatActivity, title:String, upButton:Boolean){
        activities.setSupportActionBar(activities.findViewById<Toolbar>(R.id.toolbar))
        activities.supportActionBar?.title=title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}