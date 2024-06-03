package com.example.ikamvayouth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class StudentDashboard : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
        // Get the current user
        val currentUser = mAuth.currentUser

        // Check if user is signed in (non-null) and update UI accordingly
        if (currentUser != null) {
            // Get the email from the current user
            val email = currentUser.email ?: "Email"

            // Find the EditText view by its ID
           textView = findViewById<TextView>(R.id.tvWelcome)

            // Set the retrieved email to the EditText
            val welcomeMessage = "Welcome Back, $email"
            textView.text = welcomeMessage
        }
    }
}
