package com.example.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.repository.database.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE userId = :id")
     fun getUsertById(id: Long): User?

    @Query("SELECT * FROM User")
     fun getUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(user : User): Long

    @Query("DELETE FROM User")
     fun cleanTable(): Int
}