package com.example.ikamvayouth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ikamvayouth.R.id.editTextEmail
import com.google.firebase.auth.FirebaseAuth

class StudentRegister : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var registerBtn: Button
    private lateinit var textViewLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("StudentLogin", "Context: $this")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_register)


        editTextUsername = findViewById(editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        registerBtn = findViewById(R.id.button_register)
        textViewLogin = findViewById(R.id.ViewLogin)
        mAuth = FirebaseAuth.getInstance()

        mAuth = FirebaseAuth.getInstance()

        registerBtn.setOnClickListener {
            registerUser()
        }

        textViewLogin.setOnClickListener {
            startActivity(Intent(this@StudentRegister, StudentLogin::class.java))
        }
    }

    private fun registerUser() {
        val email = editTextUsername.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this@StudentRegister, "Please enter all the details", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this@StudentRegister, "Registration successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@StudentRegister, StudentLogin::class.java))
            } else {
                Toast.makeText(this@StudentRegister, "Registration failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
