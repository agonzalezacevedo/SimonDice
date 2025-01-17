package com.example.simondice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random: Int = (0..3).random()
        val fourColors = arrayOf("Green", "Yellow", "Blue", "Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val activitiesArray = arrayOf(Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)


        for(i in 0..3){
            random = (0..3).random()
            allColors.add(fourColors[random])
        }
        val botonEmpezar = findViewById<Button>(R.id.botonEmpezar)
        botonEmpezar.setOnClickListener {
            val intent = Intent(this@MainActivity, activitiesArray[random])
            intent.putStringArrayListExtra("colors", allColors)
            intent.putExtra("count", 0)
            intent.putExtra("score", 0)
            startActivity(intent)
        }


    }
}