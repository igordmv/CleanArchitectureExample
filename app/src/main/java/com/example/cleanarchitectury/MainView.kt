package com.example.cleanarchitectury

import com.example.cleanarchitectury.users.User

internal interface MainView {
    fun showAddedUserToast(firstName : String, lastName : String)
    fun showUsers( userList : List<User>)
    fun deleteUsersFromListView()
}