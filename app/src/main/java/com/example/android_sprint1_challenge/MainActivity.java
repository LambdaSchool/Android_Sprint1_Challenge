package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE1 = 11;
    final int REQUEST_CODE = 19;

    Button addButton;
    Context context;
    LinearLayout scrollLayout;

    //final ArrayList<movieModel> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollLayout = findViewById(R.id.scroll_layout);
        addButton = findViewById(R.id.add_button);
        context = this;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent  intent = new Intent(context, editList.class);
                startActivity(intent);

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_CODE1){

                ArrayList<movieModel> movies = movieRepo.getMovieList();
                for (movieModel movie:movies)
                {
                    scrollLayout.addView(createTextView(movie.getTitle(), movie.isSeen()));

                }

            }

        }




    }
/* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {


                ArrayList<movieModel> movies = movieRepo.getMovieList();
                for (movieModel movie:movies)
                {
                    scrollLayout.addView(createTextView(movie.getTitle(), movie.isSeen()));

                }
*//*


               *//*
                //Intent finalIntent = getIntent();
                //movieModel movie = (movieModel) getIntent().getSerializableExtra("movie");

                //for (movieModel movie : movies) {*//*





                }
            }
        }
*/





    public TextView createTextView(final String title, final boolean seenIt)
    {


        final TextView tv = new TextView(getApplicationContext());
        tv.setText(title);
        //tv.setTextSize(24);
        if(seenIt)
        {
            tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    return tv;
    }
}
