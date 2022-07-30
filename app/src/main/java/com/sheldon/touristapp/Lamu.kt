package com.sheldon.touristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class Lamu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lamu)

        val lamu = findViewById<WebView>(R.id.lamu)
        lamu.loadUrl("file:///android_asset/lamu.html")

        val button =findViewById<Button>(R.id.book)

        button.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}