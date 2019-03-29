package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {


    Context context = this;
    ScrollView movieListView;
    private ArrayList<MovieModel> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);

        movieListView = findViewById(R.id.movie_listView);
        findViewById(R.id.add_movie_to_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieDetail.class);
                startActivity(intent);


            }
        });

        movieList = new ArrayList<>();
    }

    private TextView createEntryView(MovieModel entry){
        TextView textView = new TextView(context);




        textView.setText(entry.getMovieName());
        textView.setPadding(15,15,15,15);
        textView.setTextSize(25);


        return textView;
    }
}
