package com.example.signupandsignin.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.signupandsignin.Database.DBHelper
import com.example.signupandsignin.R
import com.example.signupandsignin.Model.Users

class Register : AppCompatActivity() {
    val DBHelper by lazy { DBHelper(applicationContext) }

    private lateinit var etEmail: EditText
    private lateinit var etUserName: EditText
    private lateinit var etMobile: EditText
    private lateinit var etPassword: EditText
    private lateinit var signUp: Button
    private lateinit var user: Users


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // initializing the views
        initViews()
        signUp.setOnClickListener {
            addUser()


        }
    }
        private fun addUser(){
            if (!etEmail.text.isNullOrEmpty() || !etUserName.text.isNullOrEmpty() || !etMobile.text.isNullOrEmpty() || !etPassword.text.isNullOrEmpty()) {
                val email = etEmail.text.toString()
                val name = etUserName.text.toString()
                val mobile = etMobile.text.toString()
                val password = etPassword.text.toString()
                val newUser = Users(email, name, mobile, password)
                Toast.makeText(this, "save Successfully", Toast.LENGTH_SHORT).show()
                if(DBHelper.readData(email) == null){
                    DBHelper.saveData(newUser)
                    val intent = Intent(this,UserDetails::class.java)
                    intent.putExtra("newUser",newUser)
                    startActivity(intent)
                }

            } else {
                Toast.makeText(this, "Not save Successfully", Toast.LENGTH_SHORT).show()
            }
        }

//    private fun addUser() {
//        if (etUserName.text == null || etEmail.text == null || etPassword.text == null || etMobile.text == null) {
//            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
//        } else {
//            val name = etUserName.text.toString()
//            val email = etEmail.text.toString()
//            val mobile = etMobile.text.toString()
//            val password = etPassword.text.toString()
//            val newUser = Users(name, email, mobile, password)
//
//            if (user.email == "") {
//                DBHelper.saveData(newUser)
//                val intent = Intent(this, UserDetails::class.java)
//                intent.putExtra("user", newUser)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "User is exist, please sign in", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

         fun initViews() {
            etEmail = findViewById(R.id.etEmail)
            etUserName = findViewById(R.id.etUserName)
            etMobile = findViewById(R.id.etMobile)
            etPassword = findViewById(R.id.etPassword)
            signUp = findViewById(R.id.saveButton)

        }

    }
