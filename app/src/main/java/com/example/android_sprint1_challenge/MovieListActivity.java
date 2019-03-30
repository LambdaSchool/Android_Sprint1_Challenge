package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {


    public static final int EDIT_ENTRY_REQUEST_CODE = 2;
    public static final int NEW_ENTRY_REQUEST = 1;
    private Button addMovieButton;
    Context context;
    private LinearLayout movieList;
    private ArrayList<MovieEntry> movieEntries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        context = this;

        movieList = findViewById(R.id.listViewOfMovies);

        movieEntries = new ArrayList<>();
        addMovieEntries();


        addMovieButton = findViewById(R.id.add_movie);
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButtonPage();
            }

        });

    }

    public void openButtonPage() {
        Intent intent = new Intent(this, MovieDetails.class);
        startActivity(intent);
    }

    //get list and show list here







    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (MovieEntry movieEntryEntry : movieEntries) {
            movieList.addView(generateTextView(movieEntryEntry));

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

    private TextView generateTextView(final MovieEntry entry){
        TextView textView = new TextView(context);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLUE);
        textView.setText(entry.getMovieText());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, MovieDetails.class);
                detailIntent.putExtra(MovieEntry.TAG, entry);
                startActivityForResult(detailIntent, EDIT_ENTRY_REQUEST_CODE);
            }
        });
        return textView;

    }

    private MovieEntry createMovieEntry() {
    MovieEntry entry = new MovieEntry(movieEntries.size());
    return entry;
    }

    private MovieEntry createMovieEntry(String text) {
    MovieEntry entry = createMovieEntry();
    entry.setMovieText(text);
    return entry;

    }

    private void addMovieEntries(){
    movieEntries.add(createMovieEntry());

    }


}





