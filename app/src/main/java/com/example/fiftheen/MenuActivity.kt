package com.example.fiftheen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Database


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


    fun onStart(view: View) {
        startActivity(Intent(this@MenuActivity, GameScreenActivity::class.java))
    }

    fun onExit(view: View) {
        finish()
    }
}}

