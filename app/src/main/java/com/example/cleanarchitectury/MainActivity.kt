package com.example.cleanarchitectury

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import com.example.cleanarchitectury.users.User
import android.widget.ArrayAdapter




class MainActivity : AppCompatActivity(), MainView {
    override fun deleteUsersFromListView() {
        val namelist = ArrayList<String>()
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1, namelist
        )
        userList.adapter = adapter
    }


    override fun showUsers(users: List<User>) {
        val namelist = ArrayList<String>()
        users.forEach {namelist.add(it.firstName + " " + it.lastName)}
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1, namelist
        )
        userList.adapter = adapter
    }

    override fun showAddedUserToast(firstName : String, lastName : String) {
        val namelist = ArrayList<String>()
        if(userList.adapter != null) {
            for (i in 0 until userList.adapter.getCount()) {
                namelist.add(userList.adapter.getItem(i) as String)
            }
        }
        namelist.add("$firstName $lastName")
        Log.i(TAG,"User added, showing Toast")
        Toast.makeText(this, "User added",
            Toast.LENGTH_LONG
        ).show()

        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1, namelist
        )
        userList.adapter = adapter

    }

    private val controller = MainInjection(this).make()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddUser.setOnClickListener {
            Log.i(TAG,"btnAddUser Button clicked")

            when{
                isAllEditTextsFilled() -> addUser()
                else -> showErrorToast()
            }
        }

        btnGetAll.setOnClickListener{
            Log.i(TAG,"btnGetAll Button clicked")
            controller.onGetAllUsersClicked()
        }

        btnDeleteAll.setOnClickListener{
            Log.i(TAG,"btnDeleteAll Button clicked")
            controller.onDeleteAllUsersClicked()
        }

    }

    private fun addUser() {
        Log.i(TAG,"First and Last name filled")
        controller.onAddUserClicked(
            editTextFirstName.text.toString(),
            editTextLastName.text.toString()
        )
    }

    private fun showErrorToast() {
        Log.i(TAG,"Error Toast showed, First and Last name empty")
        Toast.makeText(this, "Please, write First and Last name",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun isAllEditTextsFilled(): Boolean = !editTextFirstName.text.toString().equals("") && !editTextLastName.text.toString().equals("")


    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
}