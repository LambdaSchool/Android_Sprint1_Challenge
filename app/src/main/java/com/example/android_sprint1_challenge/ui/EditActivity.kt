package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.MovieData
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class EditActivity : AppCompatActivity() {



    companion object {
        const val MOVIE_KEY = "New Movie Key"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


   var bundle:Bundle?=intent.extras
        if(bundle!=null) {
            var selectedMovie: MovieData = bundle!!.getSerializable("SelectedMovie") as MovieData
            editText_movieName.setText(selectedMovie.name)
            watched_switch.isChecked=selectedMovie.watched

        }


        button_save.setOnClickListener {
            saveMovie()
        }
        button_delete.setOnClickListener {

        }

    }

    fun saveMovie(){
        val resultIntent = Intent()
        resultIntent.putExtra(MOVIE_KEY,MovieData(editText_movieName.text.toString(),watched_switch.isChecked))
        setResult(Activity.RESULT_OK, resultIntent)
        finish() // destroy the activity
    }
    override fun onBackPressed() {
        saveMovie()
    }
}

