package com.example.cleanarchitectury

import com.example.cleanarchitectury.users.deleteall.UserDeleter
import com.example.cleanarchitectury.users.getall.UserGetter
import com.example.cleanarchitectury.users.save.UserSaver
import com.nhaarman.mockito_kotlin.*
import org.junit.Test

class MainControllerTest {
    private val view        = mock<MainView>()
    private val userSaver   = mock<UserSaver>()
    private val userGetter  = mock<UserGetter>()
    private val userDeleter = mock<UserDeleter>()

    private val subject = MainController(view,userSaver,userGetter,userDeleter)

    @Test
    fun `test when onDeleteAllUsersClicked at controller is called userDeleter should be called`(){
        subject.onDeleteAllUsersClicked()
        verify(userDeleter, times(1)).deleteAll()
        verify(view, times(1)).deleteUsersFromListView()
    }

    @Test
    fun `test when onGetAllUsersClicked at controller is called userGetter should be called`(){
        whenever(userGetter.getAll()).thenReturn(ArrayList())
        subject.onGetAllUsersClicked()
        verify(userGetter, times(1)).getAll()
        verify(view, times(1)).showUsers(any())
    }

    @Test
    fun `test when  onAddUserClicked at controller is called and save works userSaver and view should be called`(){
        val firstName = "Peter"
        val lastName = "Parker"
        whenever(userSaver.save(firstName,lastName)).thenReturn(true)
        subject.onAddUserClicked(firstName,lastName)
        verify(userSaver, times(1)).save(firstName,lastName)
        verify(view, times(1)).showAddedUserToast(firstName,lastName)
    }

    @Test
    fun `test when onAddUserClicked at controller is called and save not works userSaver should be called but view shouldnt`(){
        val firstName = "Peter"
        val lastName = "Parker"
        whenever(userSaver.save(firstName,lastName)).thenReturn(false)
        subject.onAddUserClicked(firstName,lastName)
        verify(userSaver, times(1)).save(firstName,lastName)
        verify(view, times(0)).showAddedUserToast(firstName,lastName)
    }
}