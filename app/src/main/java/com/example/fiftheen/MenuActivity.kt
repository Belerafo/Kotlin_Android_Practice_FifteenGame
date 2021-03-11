package com.example.fiftheen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun onStart(view: View) {
        val intent = Intent(this@MenuActivity, GameScreenActivity::class.java)
        if (etNameOfGamer.text.isEmpty()) {
            Toast.makeText(applicationContext, "Введите имя игрока", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra("NameOfGamer", "${etNameOfGamer.text}")
            startActivity(intent)
        }
    }

    fun onExit(view: View) {
        finish()
    }
}

