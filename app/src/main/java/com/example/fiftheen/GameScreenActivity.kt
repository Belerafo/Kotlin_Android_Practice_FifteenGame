package com.example.fiftheen

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_screen.*


class GameScreenActivity : AppCompatActivity() {
    private var buttonsopen = mutableListOf<Button>()
    private val numbersopen = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        tvTimer.start()
        tvTimer.setOnChronometerTickListener {
            onFinishListener()
        }
        val numbers = numbersopen
        //numbers.shuffle()
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

        buttons.shuffle()
        for (i in 0..14) {
            buttons[i].text = numbers[i].toString()
        }

    }

    // Проверка на конец игры
    fun onFinishListener() {
        var finish = 0
        for (i in 0..14) {
            if (buttonsopen[i].text == (i + 1).toString()) {
                finish++
                //testView.text =" ${testView.text} ${buttonsopen[i].text} + кнопка $i"
            }
        }
        if (finish == 15) {
            //testView.text = finish.toString()
            tvTimer.stop()
        } else {
            //testView.text = finish.toString()
            finish = 0
        }
    }

        fun testCkick (view: View){

            for (i in 0..15){
               buttonsopen[i].setOnClickListener(){

                   testView.text = "${testView.text} ${buttonsopen[i].text} + кнопка $i"
               }
            }

        }


}



