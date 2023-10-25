package com.example.affirmations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val linearLayoutButton : Button = findViewById(R.id.linear_layout_button)
        val gridLayoutButton : Button = findViewById(R.id.grid_layout_button)
        val intent = Intent(this, ViewRecycler::class.java)

        linearLayoutButton.setOnClickListener{
            intent.putExtra("layout", "linear")
            startActivity(intent)
        }
        gridLayoutButton.setOnClickListener{
            intent.putExtra("layout", "grid")
            startActivity(intent)
        }
    }

}