package com.example.fiftheen.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Scoreboard {
    @PrimaryKey
    var id: Long = 0
    var name: String? = null
    var timeOfEnd = 0
}