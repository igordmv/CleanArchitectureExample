package com.example.cleanarchitectury.users.getall

import com.example.cleanarchitectury.users.User
import com.example.cleanarchitectury.users.UserRepository

class UserGetter(private val repository : UserRepository) {
    fun getAll() : List<User>{
        return repository.getAll()
    }
}