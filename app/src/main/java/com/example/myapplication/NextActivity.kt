package com.example.myapplication

import kotlinx.android.synthetic.main.activity_next.*

import android.app.Activity

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle




class NextActivity : AppCompatActivity() {



    companion object{

        const val MOVIE_ENTRY = "MOVIE_KEY"

        const val WATCHED = "WATCHED_KEY"

        const val DELETE = "DELETE_KEY"

    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_next)



        button_save.setOnClickListener {view->

            val movie = edit_entry.text.toString()

            val watched : Boolean = checkbox.isChecked

            //initiating Intent then putExtra
            val intent = Intent()
            intent.putExtra(MOVIE_ENTRY, movie)
            intent.putExtra(WATCHED, watched)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
        //initiating button_delete with an Intent here, and coding it on main activity
        button_delete.setOnClickListener {
            val movie = edit_entry.text.toString()
            val intent = Intent()
            intent.putExtra(DELETE, movie)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
    //save button and onBack Press button have the same code
    override fun onBackPressed() {
        val movie = edit_entry.text.toString()
        val watched = checkbox.isChecked
        val intent = Intent()
        intent.putExtra(MOVIE_ENTRY, movie)
        intent.putExtra(WATCHED, watched)
        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}