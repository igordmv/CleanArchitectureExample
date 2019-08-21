package com.example.cleanarchitectury

import com.example.cleanarchitectury.users.getall.UserGetter
import com.example.cleanarchitectury.users.save.UserSaver
import java.lang.ref.WeakReference

internal class MainController(view: MainView?,
                              private val userSaver : UserSaver,
                              private val userGetter : UserGetter
                                                                ) {
                              private val viewRef = WeakReference(view)

    fun onAddUserClicked(firstName : String = "Igor", lastName : String = "Vieira"){
        val saved = userSaver.save(firstName,lastName)

        when{
            saved -> viewRef.get()?.showAddedUserToast()
        }
    }

    fun onGetAllUsersClicked(){
       val users =  userGetter.getAll()
    }
}