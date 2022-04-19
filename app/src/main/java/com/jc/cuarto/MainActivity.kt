package com.jc.cuarto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.Update

class MainActivity : AppCompatActivity() {

    private val newUserActivityRequestCode = 1
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((application as UsersApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var x=2
        Log.i("XXX", " estara ${x in 1..30}")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        userViewModel.allUsers.observe(this){users->

            Log.i("XXX", "Veamos"+users.size)
            users.let { adapter.submitList(it) }


        }



    }


}