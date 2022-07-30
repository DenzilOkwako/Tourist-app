package com.sheldon.touristapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class Nakuru : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nakuru)

        val nakuru = findViewById<WebView>(R.id.nakuru)
        nakuru.loadUrl("file:///android_asset/nakuru.html")


    }
}