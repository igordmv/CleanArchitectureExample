package com.example.cleanarchitectury

import com.example.cleanarchitectury.users.User

internal interface MainView {
    fun showAddedUserToast()
    fun showUsers( userList : List<User>)
}