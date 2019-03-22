package com.rybarstudios.movielist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

    public static final int MOVIE_REQUEST_CODE = 50;
    public static final int EDIT_REQUEST_CODE = 67;
    private int nextId = 0;
    ArrayList<Movie> movieList;
    Context context;
    LinearLayout listLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        listLayout = findViewById(R.id.movie_list);


        findViewById(R.id.button_add_movie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                Movie movie = new Movie(nextId);
                intent.putExtra(Movie.TAG, movie);
                startActivityForResult(intent, MOVIE_REQUEST_CODE);
            }
        });

        movieList = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listLayout.removeAllViews();
        for(Movie movieEntry : movieList) {
            listLayout.addView(genTextView(movieEntry));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == MOVIE_REQUEST_CODE) {
            if(data != null) {
                Movie movieEntry = (Movie) data.getSerializableExtra(Movie.TAG);
                movieList = addMovie(movieEntry);
            }
        }else if(requestCode == EDIT_REQUEST_CODE) {
            if(data != null){
                Movie movieEntry = (Movie) data.getSerializableExtra(Movie.TAG);
                movieList.set(movieEntry.getId(), movieEntry);
            }
        }
    }

    private TextView genTextView(final Movie movieEntry) {
        TextView view = new TextView(context);
        view.setPadding(15,15,15,15);
        view.setText(movieEntry.getTitle());
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

        if(movieEntry.isWatched()) {
            view.setText(movieEntry.getTitle());
            view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra(Movie.TAG, movieEntry);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
                //TODO remove movie from list, then re-add it. Won't have to check for duplicates
                deleteMovie(movieEntry);
                //TODO: fix crash when list is empty after user delete

            }
        });

        return view;
    }

    public  ArrayList<Movie> addMovie(Movie movie){
        if(movie.getId() == Movie.INVALID_ID) {
            int movieIndex = movieList.size();
            movie.setId((movieIndex));
        }
        movieList.add(movie);
        return movieList;
    }


    public ArrayList<Movie> deleteMovie(Movie movie) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getId() == Movie.INVALID_ID) {
                movieList.remove(movie);
            }
        }
        return movieList;
    }
}
