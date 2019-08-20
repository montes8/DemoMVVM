package com.example.repository.database.api

import com.example.entity.UserEntity
import com.example.repository.database.dao.UserDao
import com.example.repository.database.entity.User
import com.example.usecases.repository.UserRepositoryDataBase

class UserDataBase(private val userDao: UserDao) : UserRepositoryDataBase {
    @Throws(Exception::class)
    override fun insertUser(user : UserEntity): UserEntity {
        val newId  = userDao.insert(User.toUser(user))
        val newUser = userDao.getUsertById(newId)
        return UserEntity(newUser?.userId,newUser?.username,newUser?.fullname)
    }
}