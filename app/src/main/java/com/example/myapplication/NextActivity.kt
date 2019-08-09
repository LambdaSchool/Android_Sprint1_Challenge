package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {
    companion object {
        const val ENTRY_REQUEST = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        button_save.setOnClickListener {
            val movie = edit_entry.text.toString()


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Name", movie)

            startActivity(intent)
        }


    }

}
