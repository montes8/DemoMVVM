package com.example.usecases.repository


interface UserRepositoryPreference {
    fun getToken(): String
    fun saveToken(token: String)
}