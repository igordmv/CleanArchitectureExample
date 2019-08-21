package com.example.cleanarchitectury.save

class UserSaver (private val repository : UserRepository){
    fun save(firstName : String, lastName : String) : Boolean {
        val user = User(firstName, lastName)
        return repository.save(user)
    }
}