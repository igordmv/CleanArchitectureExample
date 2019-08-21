package com.example.cleanarchitectury

import com.example.cleanarchitectury.save.UserSaver
import com.example.cleanarchitectury.save.repository.UserRepositoryAccess
import com.example.database.UsersDB
import java.lang.ref.WeakReference

internal class MainInjection(activity: MainActivity?) {

    private val activityRef = WeakReference(activity)

    fun make(): MainController {
        val mainActivity = activityRef.get()

        val userSave = UserSaver( UserRepositoryAccess( UsersDB(mainActivity!!)))

        return MainController(mainActivity, userSave)
    }
}