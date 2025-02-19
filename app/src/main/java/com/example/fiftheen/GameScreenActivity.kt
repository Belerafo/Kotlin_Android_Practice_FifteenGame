package com.example.fiftheen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_screen.*

class GameScreenActivity : AppCompatActivity() {
    var time = "9999"
    var name = "Noone"
    var pref : SharedPreferences? = null
    private var buttonsopen = mutableListOf<Button>()
    private val numbersopen = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        time = pref?.getString("time","9999")!!
        name = pref?.getString("name","Noone")!!

           tvBestTime.text = "Лучшее время \n  $name - $time"

        tvNameOfGame2.movementMethod = ScrollingMovementMethod()
        tvTimer.start()
        tvTimer.setOnChronometerTickListener {
            onFinishListener()
        }
        createStartPos()
    }

    // Проверка на конец игры
    fun onFinishListener() {
        var nameOfGamer = intent.getStringExtra("NameOfGamer").toString()
        var finish = 0
        for (i in 0..14) {
            if (buttonsopen[i].text == (i + 1).toString()) {
                finish++
                //testView.text =" ${testView.text} ${buttonsopen[i].text} + кнопка $i"
            }
        }
        if (finish == 15) {
            tvProgress.text = "Game over"
            tvTimer.stop()
            if (removeChars("${tvTimer.text}", ":").toInt() < removeChars("$time", ":").toInt()) {
                saveData()
            }
        } else {
            tvProgress.text = "Прогресс игры : ${finish * 100 / 15}%"
            finish = 0
        }
        //добавление
    }

    fun createStartPos() {
        val numbers = numbersopen
        numbers.shuffle()
        val buttons = mutableListOf<Button>(
            line1Button1,
            line1Button2,
            line1Button3,
            line1Button4,
            line2Button1,
            line2Button2,
            line2Button3,
            line2Button4,
            line3Button1,
            line3Button2,
            line3Button3,
            line3Button4,
            line4Button1,
            line4Button2,
            line4Button3,
            line4Button4
        )
        buttonsopen = buttons
        //buttons.shuffle()
        for (i in 0..14) {
            buttons[i].text = numbers[i].toString()
        }
        onTurn()
    }

    // Game Process
    fun onTurn() {
        for (i in 0..15) {
            buttonsopen[i].setOnClickListener() {
                //when {
                if ((i + 1) in 0..15) {
                    if (buttonsopen[i + 1].text == "" && i != 3 && i != 7 && i != 11) {
                        buttonsopen[i + 1].text = buttonsopen[i].text
                        buttonsopen[i].text = ""
                    }
                }

                if ((i - 1) in 0..15) {
                    if (buttonsopen[i - 1].text == "" && i != 12 && i != 8 && i != 4) {
                        buttonsopen[i - 1].text = buttonsopen[i].text
                        buttonsopen[i].text = ""
                    }
                }
                if ((i + 4) in 0..15) {
                    if (buttonsopen[i + 4].text == "") {
                        buttonsopen[i + 4].text = buttonsopen[i].text
                        buttonsopen[i].text = ""
                    }
                }

                if ((i - 4) in 0..15) {
                    if (buttonsopen[i - 4].text == "") {
                        buttonsopen[i - 4].text = buttonsopen[i].text
                        buttonsopen[i].text = ""
                    }
                }
                // testView.text = "${testView.text} ${buttonsopen[i].text} + кнопка $i"
            }
        }
    }
    fun saveData()
    {
        val editor = pref?.edit()

        editor?.putString("time","${tvTimer.text}")
        editor?.putString("name", intent.getStringExtra("NameOfGamer").toString( ))
        editor?.apply()

    }


    fun removeChars(s: String, c: String) = s.replace(Regex("[$c]"), "")
    fun onScoreboardClick(view: View) {
//        var nameOfGamer = intent.getStringExtra("NameOfGamer").toString()
//       bScoreboard.text = nameOfGamer
    }
}




