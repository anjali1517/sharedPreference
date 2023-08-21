package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    lateinit var storeUser:EditText
    lateinit var storePass:EditText
    lateinit var btnLogout: Button
    lateinit var sharedpreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

       storeUser = findViewById(R.id.storeUser)
       storePass = findViewById(R.id.storePass)
        btnLogout = findViewById(R.id.btnLogout)
    }

    override fun onResume() {
        super.onResume()

        sharedpreference =
            this.getSharedPreferences("com.example.sharedpreference", Context.MODE_PRIVATE)

        var uname:String = sharedpreference.getString("username","").toString()
        var pwd:String = sharedpreference.getString("password","").toString()
        storeUser.setText(uname)
        storePass.setText(pwd)

        if(uname.isNullOrEmpty() && pwd.isNullOrEmpty()){
            var intent:Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        btnLogout.setOnClickListener(){
           var edit:SharedPreferences.Editor = sharedpreference.edit()
            //to remove the data from file
            edit.clear()
            //synocronation
            edit.commit()
            finish()
        }
    }
}