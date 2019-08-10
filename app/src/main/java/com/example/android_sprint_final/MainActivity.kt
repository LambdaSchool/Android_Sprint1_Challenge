package com.example.android_sprint_final

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val MOVIE_REQUEST = 654
        const val TEXT_VIEW_REQUEST = "143"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movie_button.setOnClickListener {view ->
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, MOVIE_REQUEST)
        }
    }

    fun createTextView(content : String, has_been_watched : Boolean) : TextView{
        val text_view = TextView(this)
        text_view.text = content
        text_view.textSize = 24f
        text_view.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        if(has_been_watched == true){
            text_view.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
        }

        text_view.setOnClickListener {
            movie_layout.removeView(text_view)
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra(TEXT_VIEW_REQUEST, text_view.getText().toString())
            startActivityForResult(intent, MOVIE_REQUEST)
        }

        return text_view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                MOVIE_REQUEST -> {
                    val text = data?.getStringExtra(EditActivity.MOVIE_ENTRY)
                    val watched = data?.getBooleanExtra(EditActivity.WATCHED_OR_NOT, false)
                    val delete = data?.getStringExtra(EditActivity.DELETE_MOVIE)

                    if(text != null && text.equals("") == false && watched != null){
                        val t : TextView = createTextView(text, watched)
                        movie_layout.addView(t)
                    } else if(delete != null && !delete.equals("")){
                        for (x in 0..(movie_layout.childCount)){
                            val t_view : TextView = movie_layout.getChildAt(x) as TextView
                            if(t_view.text.equals(delete)){
                                movie_layout.removeViewAt(x)
                            }
                        }
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}

