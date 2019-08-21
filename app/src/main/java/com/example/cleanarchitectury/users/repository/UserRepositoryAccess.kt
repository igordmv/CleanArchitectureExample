package com.example.cleanarchitectury.users.repository

import com.example.cleanarchitectury.users.User
import com.example.cleanarchitectury.users.UserRepository
import com.example.database.UsersDB

class UserRepositoryAccess(private val userDB : UsersDB) : UserRepository {
    override fun deleteAll() {
        userDB.deleteAll()
    }

    override fun getAll(): List<User> {
        val userDBList : List<com.example.database.User>  = userDB.getAll()
        val userList = ArrayList<User>()
        userDBList.forEach(action = {
            userList.add(User(it.firstName,it.lastName))
        })
        return userList
    }

    override fun save(user: User) : Boolean {
       return userDB.addUser(user.firstName,user.lastName)
    }
}