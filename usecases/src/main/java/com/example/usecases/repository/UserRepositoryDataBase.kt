package com.example.usecases.repository

import com.example.entity.UserEntity


interface UserRepositoryDataBase {
    @Throws(Exception::class)
    fun insertUser(user : UserEntity): UserEntity
}