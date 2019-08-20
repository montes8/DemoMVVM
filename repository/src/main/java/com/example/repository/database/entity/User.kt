package com.example.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.entity.UserEntity

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Long,
    var username: String,
    var fullname: String){

    companion object{
        fun toUser(user : UserEntity): User {
            return User(user.userId!!,user.username!!,user.fullname!!)
        }
    }
}

