package com.example.signupandsignin.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.signupandsignin.R

class MainActivity : AppCompatActivity() {
    private lateinit var signUp:Button
    private lateinit var signin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signin = findViewById(R.id.sign_InButton)
        signUp = findViewById(R.id.sign_upButton)
        signUp.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        signin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}