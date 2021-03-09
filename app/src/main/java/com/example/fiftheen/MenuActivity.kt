package com.example.fiftheen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fiftheen.Database.AppDatabase
import com.example.fiftheen.Database.Scoreboard
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    private val db = AppDatabase.getInstance(application)
    val score = db.getScoreboardDao().getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }



    fun onStart(view: View) {
        startActivity(Intent(this@MenuActivity, GameScreenActivity::class.java))
        //добавление
        val employee = Scoreboard()
        employee.id = 1
        employee.name = etNameOfGamer.text.toString()
        employee.timeOfEnd = 10000
        db.getScoreboardDao().insert(employee)
    }

    fun onExit(view: View) {
        finish()
    }
}

