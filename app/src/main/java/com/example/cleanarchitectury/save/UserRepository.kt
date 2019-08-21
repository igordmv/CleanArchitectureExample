package com.example.cleanarchitectury.save

interface UserRepository {
        fun save(user : User) : Boolean
}
