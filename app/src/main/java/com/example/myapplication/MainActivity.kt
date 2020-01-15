package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    //lateinit var -> nos permite minimizar la llamada del findViewById como se muestra mas abajo
    lateinit var diceImage : ImageView
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var diceImage3 : ImageView
    lateinit var rollButton: Button
    lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewByIn =  metodo para obtener una view de la clase del xml
        //val rollButton: Button = findViewById(R.id.roll_button)

        //De una manera mas optimizada declarando con lateinit para el cast cambia
        rollButton = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)

        deleteButton = findViewById(R.id.delete_button)
        //Llamada a la funcion del button
        rollButton.setOnClickListener { (rollDice(getRandomDiceImage(),getRandomDiceImage(), getRandomDiceImage(), getRandomDiceImage())) }
        deleteButton.setOnClickListener { deleteButton() }
    }
    private fun rollDice(valorDeImage : Int, valorDeImage1: Int, valorDeImage2 : Int, valorDeImage3 : Int ) {
        diceImage.setImageResource(valorDeImage)
        diceImage1.setImageResource(valorDeImage1)
        diceImage2.setImageResource(valorDeImage2)
        diceImage3.setImageResource(valorDeImage3)
    }
    fun getRandomDiceImage() : Int {
        val randomInt = Random().nextInt(6)+1
        val drawableResourse = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResourse
    }
    private fun deleteButton(){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        diceImage3.setImageResource(R.drawable.empty_dice)
    }
}
