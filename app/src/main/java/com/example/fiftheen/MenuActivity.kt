package com.example.fiftheen

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fiftheen.Database.AppDatabase
import com.example.fiftheen.Database.Scoreboard
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }



    fun onStart(view: View) {

        val intent = Intent(this@MenuActivity,GameScreenActivity::class.java)
        intent.putExtra("NameOfGamer", "${etNameOfGamer.text}")
        startActivity(intent)


    }

    fun onExit(view: View) {
        finish()
    }
}

