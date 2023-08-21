package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtUser:EditText
    lateinit var edtPassword:EditText
    lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUser = findViewById(R.id.edtuser)
        edtPassword = findViewById(R.id.edtPwd)
        btnLogin = findViewById(R.id.btnLogin)

    }

    override fun onStart() {
        super.onStart()
        btnLogin.setOnClickListener(){

                //sharedPreference
                                                                    //file name-
                var sharedPreferences = this.getSharedPreferences("com.example.sharedpreference",Context.MODE_PRIVATE)
                var editSharedPreference = sharedPreferences.edit() //create an object of Editor class
                editSharedPreference.putString("username",edtUser.text.toString()) //pass key and value which we wan
                editSharedPreference.putString("password",edtPassword.text.toString()) //pass key and value which we wan
                //to save the data as asyscronization
                editSharedPreference.apply()

                var intent:Intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }

        }
    }
