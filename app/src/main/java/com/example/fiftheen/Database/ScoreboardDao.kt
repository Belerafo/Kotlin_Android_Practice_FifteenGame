package com.example.fiftheen.Database

import androidx.room.*


@Dao
interface ScoreboardDao {
    @get:Query("SELECT * FROM Scoreboard")
    val all: List<Any?>?

    @Insert
    fun insert(scoreboard: Scoreboard)

    @Update
    fun update(scoreboard: Scoreboard)
}



