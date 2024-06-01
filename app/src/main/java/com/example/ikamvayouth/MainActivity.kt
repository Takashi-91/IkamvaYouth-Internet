package com.example.ikamvayouth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var startBtn:Button=findViewById(R.id.startBtn)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {

            val intent = Intent(this, ConfirmationScreen::class.java)
            startActivity(intent)
        }

    }
}