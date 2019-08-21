package com.example.cleanarchitectury.save.repository

import com.example.cleanarchitectury.save.User
import com.example.cleanarchitectury.save.UserRepository
import com.example.database.UsersDB

class UserRepositoryAccess(private val userDB : UsersDB) : UserRepository {
    override fun save(user: User) : Boolean {
       return userDB.addUser(user.firstName,user.lastName)
    }
}