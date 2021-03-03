package com.example.fiftheen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_screen.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class GameScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        tvTimer.start()
        val numbers = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
        numbers.shuffle()
        line1Button1.text = numbers[0].toString()
        line1Button2.text = numbers[1].toString()
        line1Button3.text = numbers[2].toString()
        line1Button4.text = numbers[3].toString()
        line2Button1.text = numbers[4].toString()
        line2Button2.text = numbers[5].toString()
        line2Button3.text = numbers[6].toString()
        line2Button4.text = numbers[7].toString()
        line3Button1.text = numbers[8].toString()
        line3Button2.text = numbers[9].toString()
        line3Button3.text = numbers[10].toString()
        line3Button4.text = numbers[11].toString()
        line4Button1.text = numbers[12].toString()
        line4Button2.text = numbers[13].toString()
        line4Button3.text = numbers[14].toString()
        line4Button4.text = numbers[15].toString()
    }
}



