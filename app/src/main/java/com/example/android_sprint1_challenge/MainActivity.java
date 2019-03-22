package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoutLinear;
    Intent fullIntent;
    Button addButton;
    Context context;
    Boolean viewed;
    ArrayList movieArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent saveMovie =getIntent();
        saveMovie.getExtras();
        String movieName = saveMovie.getStringExtra("movieName");


        if(movieName != null){
            movieArray.add(movieName);
            int listIndex = movieArray.indexOf(movieName);
            String storedMovieName = movieArray.get(listIndex).toString();
            Boolean isViewed = (Boolean) saveMovie.getSerializableExtra("watched");
            createTextView(storedMovieName,listIndex, isViewed);
        }

        addButton = findViewById(R.id.button_add_movie);
        context = this;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovie = new Intent(context, MovieDeltails.class);
                startActivity(addMovie);




            }
        });



    }












    public TextView createTextView(final String imageText, final int listIndex, final Boolean isViewed){
        fullIntent = new Intent(MainActivity.this, MovieDeltails.class);
        TextView        textView        = new TextView (getApplicationContext ());
        layoutLinear    = findViewById ( R.id.scroll_view );
        layoutLinear.addView ( textView);
        textView.setId ( listIndex );
        textView.setText ( imageText );
        textView.setTextSize(15);
        textView.setPadding ( 10,10,10,10 );
        textView.setWidth ( 200);
        textView.setHeight ( 100 );
        if(isViewed){
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        }else {textView.setTextColor(getResources().getColor(R.color.colorAccent));}



        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                fullIntent.putExtra("index", listIndex);
                fullIntent.putExtra("name", imageText );
                fullIntent.putExtra("isviewed", isViewed);
                startActivity(fullIntent);


            }
        });

        return textView;
    }

}