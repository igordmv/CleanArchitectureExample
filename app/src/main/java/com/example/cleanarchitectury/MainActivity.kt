package com.example.cleanarchitectury

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    override fun doSomethingWhenButtonClicked() {
        Log.e("IGOR","BUTTON CLICKED")
    }

    private val controller = MainInjection(this).make()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartAnotherActivity.setOnClickListener {
            controller.onButtonClicked()
        }

    }
}