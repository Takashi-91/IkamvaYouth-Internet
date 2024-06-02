package com.example.ikamvayouth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ConfirmationScreen : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            Log.d("ConfirmationScreen", "Context: $this")
            setContentView(R.layout.activity_confirmation_screen)

            val buttonTeacher: Button = findViewById(R.id.button_teacher)
            val buttonStudent: Button = findViewById(R.id.button_student)


            buttonTeacher.setOnClickListener {
                val intent = Intent(this, StudentLogin::class.java)
                startActivity(intent)
            }

            buttonStudent.setOnClickListener {
                val intent = Intent(this, StudentLogin::class.java)
                startActivity(intent)
            }
        }
    }
