package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.new_dice)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}

        val clearButton: Button = findViewById(R.id.clear)
        clearButton.setOnClickListener { clearDice() }

    }
    private fun clearDice(){
        diceImage2.setImageResource(R.drawable.empty_dice)
        diceImage.setImageResource(R.drawable.empty_dice)
    }

    private fun getRandomDiceImage(): Int{
        val randomInt = (1..6).random()
        val drawableResource = when(randomInt){
            1->R.drawable.dice_1
            2-> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
    private fun rollDice(){

        diceImage2.setImageResource(getRandomDiceImage())
        diceImage.setImageResource(getRandomDiceImage())
    }


}
