package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewByIn =  metodo para obtener una view de la clase del xml
        //val rollButton: Button = findViewById(R.id.roll_button)

        //De una manera mas optimizada declarando con lateinit para el cast cambia
        rollButton = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
        //Llamada a la funcion del button
        rollButton.setOnClickListener { (rollDice()) }


    }
    private fun rollDice(){
        //Toast.makeText(this, "button click",Toast.LENGTH_LONG).show()
        val randomInt = Random().nextInt(6) + 1


        val drawableResourse = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResourse)
    }

}
