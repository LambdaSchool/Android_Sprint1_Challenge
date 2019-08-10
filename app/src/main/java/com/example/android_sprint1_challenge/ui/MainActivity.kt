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
import android.graphics.Paint

class MainActivity : AppCompatActivity() {
    internal var movieList: ArrayList<MovieData> = ArrayList()

    companion object {
        const val REQUEST_CODE_ADD_MOVIE = 1

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
        if (requestCode == REQUEST_CODE_ADD_MOVIE&&resultCode==Activity.RESULT_OK) {

                    val newMovie = data!!.getSerializableExtra(EditActivity.MOVIE_KEY)as MovieData
                    movieList.add(newMovie)
                    list_layout.addView(createTextView(newMovie,movieList.size-1))

    }
        else if(requestCode == REQUEST_CODE_ADD_MOVIE&&resultCode==Activity.RESULT_CANCELED){
        /*This is the result for Delete Button Listener from EditActivity
            we don't do anything here because the view and MovieData is already removed when we go to Edit movie Page
            */
        }

            super.onActivityResult(requestCode, resultCode, data)

    }
    fun createTextView(movie: MovieData,index:Int): TextView {
        val view = TextView(this)
        view.text = movie.name
        view.textSize = 24f
        view.id=index
       if(movie.watched)
            view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        view.setOnClickListener {

            val intent = Intent(this,EditActivity::class.java)
            intent.putExtra("SelectedMovie",movieList[index])
            movieList.removeAt(index)
            startActivityForResult(intent,  REQUEST_CODE_ADD_MOVIE)
            list_layout.removeView(view)
        }


        return view
    }


}
