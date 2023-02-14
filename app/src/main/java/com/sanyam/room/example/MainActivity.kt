package com.sanyam.room.example

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Below code is used only for testing
        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactsDao().insertContact(Contact(0, "John", "99999", Date(), 1))
        }
    }

    fun getData(view: View) {
        database.contactsDao().getContacts().observe(this, Observer {
            Log.d("CODES : ", it.toString())
        })
    }
}