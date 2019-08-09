package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_next.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val NEW_ENTRY_REQUEST = 1

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val movie = intent.getStringExtra("Name")
        val finalView = findViewById<TextView>(R.id.final_view)

        finalView.text = "Movie: $movie"



        button_add_movie.setOnClickListener {
            val nextScreenIntent = Intent (this, NextActivity::class.java)
            startActivityForResult(nextScreenIntent, NEW_ENTRY_REQUEST)
        }

    }
}
