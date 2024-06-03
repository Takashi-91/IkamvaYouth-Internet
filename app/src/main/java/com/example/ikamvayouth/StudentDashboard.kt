package com.example.ikamvayouth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.google.firebase.auth.FirebaseAuth

class StudentDashboard : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var textView:TextView
    private lateinit var subject: Button
    private lateinit var resources: Button
    private lateinit var tasks: Button
    private lateinit var marks: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        subject=findViewById(R.id.btnSubjectHub)
        resources=findViewById(R.id.btnResources)
        tasks=findViewById(R.id.btnTestsAssignments)
        marks=findViewById(R.id.btnCalendar)


        subject.setOnClickListener {
            val intent = Intent(this, Grade::class.java)
            startActivity(intent)
        }

        resources.setOnClickListener {
            val intent = Intent(this, Resources::class.java)
            startActivity(intent)
        }
        tasks.setOnClickListener {
            val intent = Intent(this, TestsAndAssignments::class.java)
            startActivity(intent)
        }
        marks.setOnClickListener {
            val intent = Intent(this, MarksAndFeedback::class.java)
            startActivity(intent)
        }

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
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
