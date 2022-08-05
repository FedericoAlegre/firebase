package com.fede.firebase.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var email: String, var name:String, var last:String, var password:String):Parcelable{
    constructor(): this ("","","","")
}
