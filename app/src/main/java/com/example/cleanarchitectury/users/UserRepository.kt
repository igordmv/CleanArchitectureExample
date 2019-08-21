package com.example.cleanarchitectury.users

interface UserRepository {
        fun save(user : User) : Boolean
        fun getAll() : List<User>
}
