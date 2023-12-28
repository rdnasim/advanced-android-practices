package com.riadul.advancedandroid.room_migration

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDAO {

    @Insert
    suspend fun insertStudent(student: Student)
}