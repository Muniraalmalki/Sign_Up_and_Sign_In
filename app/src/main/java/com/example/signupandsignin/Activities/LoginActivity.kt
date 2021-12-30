package com.example.signupandsignin.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.signupandsignin.Database.DBHelper
import com.example.signupandsignin.R

class LoginActivity : AppCompatActivity() {
    val DBHelper by lazy { DBHelper(applicationContext) }
    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (email !="" && password != "")
            {
                val login = DBHelper.readData(email)
                Log.d("login", "onCreate: e_user")
                if(login != null)
                {
                    //check password
                    if (login.password == password)
                    {
                        val intent = Intent(this,UserDetails::class.java)
                        intent.putExtra("newUser",login)
                        startActivity(intent)
                        Log.d("intent", "onCreate: $intent")
                    }
                    else{
                        Toast.makeText(this,"wrong password",Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this,"User doesn't exists",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"please Enter all fields",Toast.LENGTH_SHORT).show()
            }
        }
    }
}