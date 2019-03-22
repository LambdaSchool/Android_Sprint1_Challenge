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
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Intent intent = getIntent();
        if ((intent.getSerializableExtra("movieList") != null)) {
            movieList = (ArrayList) intent.getSerializableExtra("movieList");
        }

        //TextView Generation
        for (int i = 0; i < movieList.size(); ++i){
            MovieData temp = movieList.get(i);
            LinearLayout linearLayout = findViewById(R.id.linear_layout_parent);
            linearLayout.addView(textViewGenerator(temp.getTitle(),temp.isWatched(), i));
        }

        Button addMovie = findViewById(R.id.button_add_movie);
        //Add Movie's Onclick Listener
        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsView.class);
                intent.putExtra("movieList", movieList);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });


    }

    private TextView textViewGenerator(String title, boolean watched, final int index) {
        TextView tv = new TextView(context);
        tv.setText(title);
        if (!watched) {
            tv.setTypeface(Typeface.DEFAULT_BOLD);
        }

        //Each Listed Item's onClick Listener
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsView.class);
                intent.putExtra("movieList", movieList);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });
        return tv;
    }
}
