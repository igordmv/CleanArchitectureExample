package com.example.cleanarchitectury.users.getall

import com.example.cleanarchitectury.MainController
import com.example.cleanarchitectury.MainView
import com.example.cleanarchitectury.users.deleteall.UserDeleter
import com.example.cleanarchitectury.users.save.UserSaver
import com.nhaarman.mockito_kotlin.*
import org.junit.Test


class UserGetterTest {
    private val view        = mock<MainView>()
    private val userSaver   = mock<UserSaver>()
    private val userGetter  = mock<UserGetter>()
    private val userDeleter = mock<UserDeleter>()

    private val subject = MainController(view,userSaver,userGetter,userDeleter)

    @Test
    fun `test when getAll clicked expect get users and show at view`(){
        whenever(userGetter.getAll()).thenReturn(ArrayList())
        subject.onGetAllUsersClicked()
        verify(userGetter, times(1)).getAll()
        verify(view, times(1)).showUsers(any())
    }
}