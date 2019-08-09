package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.MovieData
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var movieList: ArrayList<MovieData> = ArrayList()

    companion object {
        const val REQUEST_CODE_ADD_MOVIE = 1
        const val REQUEST_CODE_DELETE_MOVIE = 2
        const val REQUEST_CODE_EDIT_MOVIE = 3
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_addMovie.setOnClickListener {
            val intent = Intent(this,EditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_MOVIE)

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //  process result from the edit activity
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_ADD_MOVIE -> {
                    val newMovie = data!!.getSerializableExtra(EditActivity.MOVIE_KEY)as MovieData
                    movieList.add(newMovie)
                    list_layout.addView(createTextView(newMovie.name,movieList.size-1))
                }
                REQUEST_CODE_DELETE_MOVIE->{

                }
                REQUEST_CODE_EDIT_MOVIE->{

                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun createTextView(movieName: String,index:Int): TextView {
        val view = TextView(this)
        view.text = movieName
        view.textSize = 24f
        view.tag=index

        view.setOnClickListener {


        }

        return view
    }

    }
