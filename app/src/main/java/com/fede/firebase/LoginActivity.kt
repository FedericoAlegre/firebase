package com.fede.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fede.firebase.models.User
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE="OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email= findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val logIn = findViewById<Button>(R.id.loginBtn)
        val db = FirebaseFirestore.getInstance();
        logIn.setOnClickListener {
            val user = db.collection("users").whereEqualTo("email", email.text.toString()).whereEqualTo("password", password.text.toString()).get()
                .addOnSuccessListener {
                    it?.let {
                        if(it.size() >0){
                            val mainActivity = Intent(this, MainActivity::class.java)

                            val user = User(it.documents[0]["email"].toString(),
                                it.documents[0]["name"].toString(),
                                it.documents[0]["last"].toString(),
                                it.documents[0]["password"].toString())
                           mainActivity.putExtra(INTENT_PARCELABLE, user)

                            startActivity(mainActivity)
                        }
                        else{
                            it.let {
                                    Toast.makeText(this, "email o contrasenia incorrecta", Toast.LENGTH_LONG).show() }

                        }

                    }
                }
                .addOnFailureListener {
                    it.let {
                        Toast.makeText(this, "Upps, algo salio mal...", Toast.LENGTH_LONG).show() }

                }


        }

        val registerBtn = findViewById<Button>(R.id.button2)
        registerBtn.setOnClickListener {
            val registerActivity = Intent(this, RegisterActivity::class.java)

            startActivity(registerActivity)
        }
    }
}