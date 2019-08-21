package com.example.cleanarchitectury

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.R.attr.data
import android.app.PendingIntent.getActivity


class MainActivity : AppCompatActivity(), MainView {
    override fun doSomethingWhenButtonClicked() {
        Log.e("IGOR","BUTTON CLICKED")
        Toast.makeText(this, "User added",
            Toast.LENGTH_LONG
        ).show()

    }

    private val controller = MainInjection(this).make()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddUser.setOnClickListener {
            controller.onAddUserClicked(editTextFirstName.text.toString(), editTextLastName.text.toString())
        }

    }
}