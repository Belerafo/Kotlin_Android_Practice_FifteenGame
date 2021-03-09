package com.example.fiftheen.Database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ScoreboardDao {
    @Query("SELECT * FROM Scoreboard")
    fun getAll(): LiveData<List<Scoreboard>>

    @Insert
    fun insert(scoreboard: Scoreboard)

    @Update
    fun update(scoreboard: Scoreboard)
}



