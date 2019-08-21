package com.example.cleanarchitectury

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity(), MainView {
    override fun showAddedUserToast() {
        Log.i(TAG,"User addded, showing Toast")
        Toast.makeText(this, "User added",
            Toast.LENGTH_LONG
        ).show()

    }

    private val controller = MainInjection(this).make()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddUser.setOnClickListener {
            Log.i(TAG,"btnAddUser Button clicked")
            controller.onAddUserClicked(editTextFirstName.text.toString(), editTextLastName.text.toString())
        }

        btnGetAll.setOnClickListener{
            Log.i(TAG,"btnGetAll Button clicked")
            controller.onGetAllUsersClicked()
        }

    }
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
}