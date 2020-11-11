package com.example.simondice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonEmpezar = findViewById<Button>(R.id.botonEmpezar)
        botonEmpezar.setOnClickListener {
            val intent = Intent(this,Game::class.java)
            startActivity(intent)
        }
    }
}