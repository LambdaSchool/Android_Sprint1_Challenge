package com.example.android_sprint_final

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    companion object{
        const val MOVIE_ENTRY = "ENTRY_MOVIE_KEY"
        const val WATCHED_OR_NOT = "ENTRY_WATCHED_KEY"
        const val DELETE_MOVIE = "ENTRY_DELETE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val data = intent.getStringExtra(MainActivity.TEXT_VIEW_REQUEST)

        if(data != null){ //must have clicked on a text view
            movie_text.setText(data)
        }

        save_button.setOnClickListener {view->
            onBackPressed()
        }

        delete_button.setOnClickListener {view ->
            val movie = movie_text.text
            val intent = Intent()
            intent.putExtra(DELETE_MOVIE, movie)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    override fun onBackPressed() {
        val movie = movie_text.getText().toString()
        val watched = watched_or_not.isChecked()

        val intent = Intent()

        intent.putExtra(MOVIE_ENTRY, movie)
        intent.putExtra(WATCHED_OR_NOT, watched)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}
