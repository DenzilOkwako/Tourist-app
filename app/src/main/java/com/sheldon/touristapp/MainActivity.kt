package com.sheldon.touristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val masaimara = findViewById<Button>(R.id.masaimara)
        masaimara.setOnClickListener {
            val index = Intent(applicationContext, Masaimara::class.java)
            startActivity(index)

        }
        val tsavo = findViewById<Button>(R.id.tsavo)
        tsavo.setOnClickListener {
            val index = Intent(applicationContext, Tsavo::class.java)
            startActivity(index)

        }
        val nairobi = findViewById<Button>(R.id.nairobi)
        nairobi.setOnClickListener {
            val index = Intent(applicationContext, Nairobi::class.java)
            startActivity(index)

        }
        val diani = findViewById<Button>(R.id.diani)
        diani.setOnClickListener {
            val index = Intent(applicationContext, Diani::class.java)
            startActivity(index)

        }
        val nakuru = findViewById<Button>(R.id.nakuru)
        nakuru.setOnClickListener {
            val index = Intent(applicationContext, Nakuru::class.java)
            startActivity(index)

        }
        val lamu = findViewById<Button>(R.id.lamu)
        lamu.setOnClickListener {
            val index = Intent(applicationContext, Lamu::class.java)
            startActivity(index)

        }


    }
}
