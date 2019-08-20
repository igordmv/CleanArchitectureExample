package com.example.cleanarchitectury

import java.lang.ref.WeakReference

internal class MainInjection(activity: MainActivity?) {

    private val activityRef = WeakReference(activity)

    fun make(): MainController {
        val mainActivity = activityRef.get()
        return MainController(mainActivity)
    }
}