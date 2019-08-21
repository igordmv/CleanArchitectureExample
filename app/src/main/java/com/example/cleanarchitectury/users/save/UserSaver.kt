package com.example.cleanarchitectury.users.save

import com.example.cleanarchitectury.users.User
import com.example.cleanarchitectury.users.UserRepository

class UserSaver (private val repository : UserRepository){
    fun save(firstName : String, lastName : String) : Boolean {
        val user = User(firstName, lastName)
        return repository.save(user)
    }
}