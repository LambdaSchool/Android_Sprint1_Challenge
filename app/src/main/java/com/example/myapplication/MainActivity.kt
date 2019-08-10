package com.example.myapplication

import android.app.Activity
import android.content.Context

import android.content.Intent

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView



import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.list_layout



class MainActivity : AppCompatActivity() {

    companion object{
        //my static constant
        const val MOVIE_REQUEST = 654

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //take me to next activity
        button_add_movie.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivityForResult(intent, MOVIE_REQUEST)
        }
    }
    //making a TextView programatically to program views for it later
    fun createTextView(content: String, has_been_watched : Boolean) : TextView{
        val listView = TextView(this)
        listView.text = content
        listView.textSize = 24f
        listView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        //cross out text
        if(has_been_watched){
            listView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        //delete views
        listView.setOnClickListener {

            list_layout.removeView(listView)
            val intent = Intent(this, NextActivity::class.java)

            startActivityForResult(intent, MOVIE_REQUEST)

        }
        return listView
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(resultCode == Activity.RESULT_OK){
            //pass words to the list
            when(requestCode){
                MOVIE_REQUEST -> {
                    val text = data?.getStringExtra(NextActivity.MOVIE_ENTRY).toString()
                    val watched = data?.getBooleanExtra(NextActivity.WATCHED, false)
                    val delete = data?.getStringExtra(NextActivity.DELETE)

                    //if list is null return null
                    if(text == null) {

                    }
                    //and if not, populate
                    if(text != null && text != "" && watched != null){

                        //listView2 is just another code for my programmatic TextView
                        val listView2 : TextView = createTextView(text, watched)

                        list_layout.addView(listView2)

                    } else if(delete != null && delete != ""){
                        for (x in 0..(list_layout.childCount)){

                            val listView3 : TextView = list_layout.getChildAt(x) as TextView

                            if(listView3.text == delete){

                                list_layout.removeViewAt(x)

                            }
                        }
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}

