package com.example.fiftheen.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Scoreboard::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var  db: AppDatabase? = null
        private const val DB_NAME ="main.db"
               fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                db?.let { return it }

                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).allowMainThreadQueries().build()
                db = instance
                return instance
            }
        }
    }

    abstract fun getScoreboardDao(): ScoreboardDao
}




