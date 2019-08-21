package com.example.cleanarchitectury.users.save

import com.example.cleanarchitectury.MainController
import com.example.cleanarchitectury.MainView
import com.example.cleanarchitectury.users.deleteall.UserDeleter
import com.example.cleanarchitectury.users.getall.UserGetter
import com.nhaarman.mockito_kotlin.*
import org.junit.Test

class UserSaverTest {
    private val view        = mock<MainView>()
    private val userSaver   = mock<UserSaver>()
    private val userGetter  = mock<UserGetter>()
    private val userDeleter = mock<UserDeleter>()

    private val subject = MainController(view,userSaver,userGetter,userDeleter)

    @Test
    fun `test when addUser clicked on working save then this user and showAddedUser at view`(){
        val firstName = "Peter"
        val lastName = "Parker"
        whenever(userSaver.save(firstName,lastName)).thenReturn(true)
        subject.onAddUserClicked(firstName,lastName)
        verify(userSaver, times(1)).save(firstName,lastName)
        verify(view, times(1)).showAddedUserToast(firstName,lastName)
    }

    @Test
    fun `test when addUser clicked on not working save then should do nothing`(){
        val firstName = "Peter"
        val lastName = "Parker"
        whenever(userSaver.save(firstName,lastName)).thenReturn(false)
        subject.onAddUserClicked(firstName,lastName)
        verify(userSaver, times(1)).save(firstName,lastName)
        verify(view, times(0)).showAddedUserToast(firstName,lastName)
    }
}