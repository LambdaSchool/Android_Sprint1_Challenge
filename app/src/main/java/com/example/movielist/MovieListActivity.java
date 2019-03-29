package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    static int nextid = 0;
    Context context = this;
    ScrollView movieListView;
    LinearLayout interListView;
    private ArrayList<MovieModel> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);

        interListView = findViewById(R.id.inter_listView);

        movieListView = findViewById(R.id.movie_listView);
        findViewById(R.id.add_movie_to_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieDetail.class);
                startActivity(intent);


            }
        });

        movieList = new ArrayList<>();
        addFakeMovies();

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        interListView.removeAllViews();
        for(MovieModel entry :movieList ){
            interListView.addView(createEntryView(entry));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private MovieModel createMovieEntry(String text){
        MovieModel entry = new MovieModel(nextid++);


        entry.setMovieName(text);


        return entry;

    }

    private TextView createEntryView(final MovieModel entry){
        TextView textView = new TextView(context);

        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(entry.getMovieName() + "-" + entry.getId());
        textView.setPadding(15,15,15,15);
        textView.setTextSize(25);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMovieEntry = new Intent(context,MovieDetail.class);
                viewMovieEntry.putExtra("entry",entry);
                startActivity(viewMovieEntry);
            }
        });


        return textView;
    }

    private void addFakeMovies(){

        movieList.add(createMovieEntry("Jaws."));
        movieList.add(createMovieEntry(" Matrix"));
    }
}
