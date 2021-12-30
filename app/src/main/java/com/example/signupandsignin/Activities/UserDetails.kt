package com.example.signupandsignin.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.signupandsignin.Database.DBHelper
import com.example.signupandsignin.R
import com.example.signupandsignin.Model.Users

class UserDetails : AppCompatActivity() {
    val DBHelper by lazy { DBHelper(applicationContext) }
    private lateinit var tvEmail:TextView
    private lateinit var tvName:TextView
    private lateinit var tvMobile:TextView
    private lateinit var tvPassword:TextView
    private lateinit var logoutButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        tvEmail = findViewById(R.id.tvEmail)
        tvName = findViewById(R.id.tvName)
        tvMobile = findViewById(R.id.tvMobile)
        tvPassword = findViewById(R.id.tvPassword)
        logoutButton = findViewById(R.id.logoutButton)

        val dis: Users = intent.getSerializableExtra("newUser") as Users


            tvEmail.setText("Email:"+ dis.email)
            tvName.setText("Name:"+dis.name)
            tvMobile.setText("Mobile: "+ dis.mobile)
            tvPassword.setText("Password: "+ dis.password)
        Log.d("TAG", "onCreate:${dis} ")

        logoutButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}