package com.example.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class UsersDB(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID Integer PRIMARY KEY, $FIRST_NAME TEXT, $LAST_NAME TEXT)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun addUser(firstName : String , lastName : String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(FIRST_NAME, firstName)
        values.put(LAST_NAME, lastName)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.i("Database", "Insert into UserDB $_success")
        return (Integer.parseInt("$_success") != -1)
    }


    fun getAll(): List<User> {
        var allUser = ArrayList<User>()
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(ID))
                    var firstName = cursor.getString(cursor.getColumnIndex(FIRST_NAME))
                    var lastName = cursor.getString(cursor.getColumnIndex(LAST_NAME))
                    allUser.add(User(id, firstName, lastName))
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allUser
    }


    fun deleteAll(){
        val db = readableDatabase
        val ERASE_TABLE = "DELETE FROM $TABLE_NAME"
        db?.execSQL(ERASE_TABLE)
    }

    companion object {
        private val DB_NAME = "UsersDB"
        private val DB_VERSIOM = 1
        private val TABLE_NAME = "user"
        private val ID = "id"
        private val FIRST_NAME = "FirstName"
        private val LAST_NAME = "LastName"
    }
}