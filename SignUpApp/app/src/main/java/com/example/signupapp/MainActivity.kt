package com.example.signupapp

import DataBase.DataSource
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map = DataSource().loadDb()
        val mainAdapter = MainAdapter(this, map)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val submitBtn: Button = findViewById(R.id.submit_btn)
        recyclerView.adapter = mainAdapter
        displayTheButton(recyclerView, submitBtn)

        submitBtn.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            map.keys.forEach { key ->

                val inputField = recyclerView.findViewById<TextInputEditText>(map.get(key)!!.toInt())
                val value = inputField.text.toString()
                if (value.trim().isEmpty()) {
                    inputField.error = "Can't be empty"
                } else {
                    map.put(key, value)
                    intent.putExtra(key, value)
                }
            }
            startActivity(intent)
        }

    }


    fun displayTheButton(recyclerView: RecyclerView, btn: Button) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    btn.visibility = View.VISIBLE
                }
            }
        })

    }
}
