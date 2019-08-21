package com.example.cleanarchitectury

import com.example.cleanarchitectury.users.deleteall.UserDeleter
import com.example.cleanarchitectury.users.getall.UserGetter
import com.example.cleanarchitectury.users.save.UserSaver
import com.example.cleanarchitectury.users.repository.UserRepositoryAccess
import com.example.database.UsersDB
import java.lang.ref.WeakReference

internal class MainInjection(activity: MainActivity?) {

    private val activityRef = WeakReference(activity)

    fun make(): MainController {
        val mainActivity = activityRef.get()

        val repositoryAccess = UserRepositoryAccess( UsersDB(mainActivity!!))

        val userSave = UserSaver(repositoryAccess)

        val userGetter = UserGetter(repositoryAccess)

        val userDeleter = UserDeleter(repositoryAccess)

        return MainController(mainActivity, userSave, userGetter, userDeleter)
    }
}