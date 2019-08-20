package com.example.usecases.usecases

import com.example.entity.UserEntity
import com.example.usecases.repository.UserRepositoryDataBase


class UserDBUseCase(var userRepositoryDataBase: UserRepositoryDataBase) {

    fun insertUser(user : UserEntity): UserEntity {
        return userRepositoryDataBase.insertUser(user)
    }
}