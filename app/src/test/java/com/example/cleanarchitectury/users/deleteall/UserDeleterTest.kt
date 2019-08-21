package com.example.cleanarchitectury.users.deleteall

import com.example.cleanarchitectury.MainController
import com.example.cleanarchitectury.MainView
import com.example.cleanarchitectury.users.getall.UserGetter
import com.example.cleanarchitectury.users.save.UserSaver
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class UserDeleterTest {
    private val view        = mock<MainView>()
    private val userSaver   = mock<UserSaver>()
    private val userGetter  = mock<UserGetter>()
    private val userDeleter = mock<UserDeleter>()

    private val subject = MainController(view,userSaver,userGetter,userDeleter)

    @Test
    fun `test when addUser clicked on working save then this user and showAddedUser at view`(){
        subject.onDeleteAllUsersClicked()
        verify(userDeleter, times(1)).deleteAll()
        verify(view, times(1)).deleteUsersFromListView()
    }
}