package com.example.android_sprint1_challenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.movieData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    companion object {

        internal const val REQUEST_IMAGE_GET = 1
    }
    internal var movieList: ArrayList<movieData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_addMovie.setOnClickListener {
            val intent = Intent(this,EditActivity::class.java)
            startActivity(intent)

        }
    }

    }
