package com.example.fiftheen

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Entity {
    @PrimaryKey
    var id: Long = 0
    var name: String? = null
    var timeOfEnd = 0
}