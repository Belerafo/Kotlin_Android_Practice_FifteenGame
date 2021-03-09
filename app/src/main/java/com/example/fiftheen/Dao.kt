package com.example.fiftheen

import androidx.room.*

@Dao
interface EmployeeDao {
    @get:Query("SELECT * FROM employee")
    val all: List<Any?>?
}