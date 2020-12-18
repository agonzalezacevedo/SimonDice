package com.example.simondice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Yellow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yellow)

        val title = findViewById<TextView>(R.id.titleText)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val green = findViewById<Button>(R.id.botonVerde)
        val yellow = findViewById<Button>(R.id.botonAmarillo)
        val blue = findViewById<Button>(R.id.botonAzul)
        val red = findViewById<Button>(R.id.botonRojo)
        val restart = findViewById<Button>(R.id.reiniciarBoton)
        val activitiesArray = arrayOf(Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)

        var score = intent.getIntExtra("score", -2)
        var count = intent.getIntExtra("count", -3)
        val colors: ArrayList<String> = intent.getStringArrayListExtra("colors") as ArrayList<String>

        scoreText.text = score.toString()

        if(score != count){
            val temp = "Color: " + (count + 1)
            title.text = temp
        } else {
            val temp = "Simon says " + colors[count]
            title.text = temp
        }

        fun gameOver(newTitle: String){
            colors[count] = newTitle
            title.text = newTitle
            restart.visibility = View.VISIBLE
            red.text = newTitle
            yellow.text = newTitle
            green.text = newTitle
        }

        // Update game based on user's choice
        fun onCorrect(answer: String, classNum: Int){
            if (colors[count] == answer){
                val intent = Intent(this@Yellow, activitiesArray[classNum])
                if((count+1) == colors.size){
                    gameOver("YOU WIN!")
                } else {
                    if (count == score) {
                        count = -1
                        score++
                    }
                    count++
                    intent.putStringArrayListExtra("colors", colors)
                    intent.putExtra("count", count)
                    intent.putExtra("score", score)
                    startActivity(intent)
                }
            }
            else if(restart.visibility != 0){
                gameOver("gameOver")
            }
        }

        // On click listeners for each button
        green.setOnClickListener {
            onCorrect("Green", 0)
        }
        yellow.setOnClickListener {
            onCorrect("Yellow", 1)
        }
        blue.setOnClickListener {
            onCorrect("Blue", 2)
        }
        red.setOnClickListener {
            onCorrect("Red", 3)
        }
        restart.setOnClickListener {
            val intent = Intent(this@Yellow, MainActivity::class.java)
            startActivity(intent)
        }
    }
}