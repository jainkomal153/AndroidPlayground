package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diceroller.R.drawable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollTheDice()
    }

    fun rollTheDice(){
        val rollButton : Button =  findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT).show()
            val diceImage : ImageView = findViewById(R.id.imageView)
            val diceRoll = Dice(6).roll()
            val diceRollImage = when(diceRoll){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> {R.drawable.dice_6}
            }
            diceImage.setImageResource(diceRollImage)
            diceImage.contentDescription = diceRoll.toString()
        }
    }
    class Dice(sides: Int){
        private val range = 1..sides
        fun roll(): Int{
            return range.random()
        }
    }
}