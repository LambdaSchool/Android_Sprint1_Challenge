package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MovieData> movieList = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Intent intent = getIntent();
        if ((ArrayList)intent.getSerializableExtra("movieList") != null) {
            movieList = (ArrayList) intent.getSerializableExtra("movieList");
        }

        for (int i = 0; i < movieList.size(); ++i){
            MovieData temp = movieList.get(i);
            LinearLayout linearLayout = findViewById(R.id.linear_layout_parent);
            linearLayout.addView(textViewGenerator(temp.getTitle(),temp.isWatched()));
        }

        Button addMovie = findViewById(R.id.button_add_movie);
        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsView.class);
                intent.putExtra("movieList", movieList);
                startActivity(intent);
            }
        });


    }

    private TextView textViewGenerator(String title, boolean watched) {
        TextView tv = new TextView(context);
        tv.setText(title);
        if (!watched) tv.setTypeface(Typeface.DEFAULT_BOLD);
        return tv;
    }
}
