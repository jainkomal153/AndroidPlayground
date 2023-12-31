package com.example.signupapp

import DataBase.DataSource
import android.annotation.SuppressLint
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.signupapp.R.layout.activity_display)

        val map = DataSource().loadDb()
        map.keys.forEach {
            key-> map.put(key, intent?.extras?.getString(key).toString())
        }
        val adapter = DisplayAdapter(this, map)
        val recyclerView = findViewById<RecyclerView>(com.example.signupapp.R.id.recycler_view)
        recyclerView.adapter = adapter


    }
}