package com.minsal.appminsal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.minsal.appminsal.R
import com.minsal.appminsal.data.Userpreferences
import com.minsal.appminsal.ui.auth.AuthActivity
import com.minsal.appminsal.ui.home.HomeActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userPreferences = Userpreferences(this)

        userPreferences.authToken.asLiveData().observe(this, Observer {
           val activity = if (it== null)  AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)

        })
    }
}