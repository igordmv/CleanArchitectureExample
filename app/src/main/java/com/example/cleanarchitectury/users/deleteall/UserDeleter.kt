package com.example.cleanarchitectury.users.deleteall

import com.example.cleanarchitectury.users.UserRepository

class UserDeleter (private val repository : UserRepository) {
    fun deleteAll() {
        return repository.deleteAll()
    }
}