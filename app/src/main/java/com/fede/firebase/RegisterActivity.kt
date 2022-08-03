package com.fede.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       /* val email=findViewById<EditText>(R.id.editTextSaveEmail)
        val password = findViewById<EditText>(R.id.editSavePassword)
        val name = findViewById<EditText>(R.id.editTextName)
        val lastName = findViewById<EditText>(R.id.editTextLastName)
        val user = User(email.text.toString(),
        name.text.toString(), lastName.text.toString(), password.text.toString())*/
        val btnSave = findViewById<Button>(R.id.buttonSaveRegister)
        btnSave.setOnClickListener {
            val email=findViewById<EditText>(R.id.editTextSaveEmail)
            val password = findViewById<EditText>(R.id.editSavePassword)
            val name = findViewById<EditText>(R.id.editTextName)
            val lastName = findViewById<EditText>(R.id.editTextLastName)
            val user = User(email.text.toString(),
                name.text.toString(), lastName.text.toString(), password.text.toString())
            val db = FirebaseFirestore.getInstance();
            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    it?.let{
                        Log.d("USER", "Guardado correctamente")
                    }
                }
                .addOnFailureListener {
                    it.let {
                        Toast.makeText(this, "Upps, algo salio mal...", Toast.LENGTH_LONG).show() }

                }
            finish()
        }

    }
}