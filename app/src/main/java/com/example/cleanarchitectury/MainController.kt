package com.example.cleanarchitectury

import com.example.cleanarchitectury.save.UserSaver
import java.lang.ref.WeakReference

internal class MainController(view: MainView?,
                              private val userSaver : UserSaver) {
                              private val viewRef = WeakReference(view)

    fun onAddUserClicked(firstName : String = "Igor", lastName : String = "Vieira"){
        val saved = userSaver.save(firstName,lastName)

        when{
            saved -> viewRef.get()?.doSomethingWhenButtonClicked()
        }
    }
}