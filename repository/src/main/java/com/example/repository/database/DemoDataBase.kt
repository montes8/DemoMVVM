package com.example.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.repository.database.dao.UserDao
import com.example.repository.database.entity.User

@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class DemoDataBase : RoomDatabase() {
    abstract val userDao: UserDao
}