package com.example.cleanarchitectury

import com.example.cleanarchitectury.users.deleteall.UserDeleter
import com.example.cleanarchitectury.users.getall.UserGetter
import com.example.cleanarchitectury.users.save.UserSaver
import java.lang.ref.WeakReference

internal class MainController(view: MainView?,
                              private val userSaver : UserSaver,
                              private val userGetter : UserGetter,
                              private val userDeleter: UserDeleter
                                                                ) {
                              private val viewRef = WeakReference(view)

    fun onAddUserClicked(firstName : String , lastName : String ){
        val saved = userSaver.save(firstName,lastName)

        when{
            saved -> viewRef.get()?.showAddedUserToast(firstName,lastName)
        }
    }

    fun onGetAllUsersClicked(){
        val users =  userGetter.getAll()
        viewRef.get()?.showUsers(users)
    }

    fun onDeleteAllUsersClicked(){
        userDeleter.deleteAll()
        viewRef.get()?.deleteUsersFromListView()
    }
}