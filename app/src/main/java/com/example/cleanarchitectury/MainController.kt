package com.example.cleanarchitectury

import java.lang.ref.WeakReference

internal class MainController(view: MainView?) {
    private val viewRef = WeakReference(view)

    fun onButtonClicked(){
        viewRef.get()?.doSomethingWhenButtonClicked()
    }
}