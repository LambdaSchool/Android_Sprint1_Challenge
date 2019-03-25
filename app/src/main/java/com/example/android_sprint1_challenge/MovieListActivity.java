package com.example.android_sprint1_challenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity implements Serializable {
    Context context;
    LinearLayout movieListView;

    public static final int ADD_IMAGE_REQUEST = 2;
    public static final int EDIT_IMAGE_REQUEST =3;

    private int movieIndex;
    private ArrayList<MovieEntry> movies;
    private ArrayList<TextView> movieViews;




//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(resultCode == RESULT_OK && requestCode == ACTIVITY_REQUEST_CODE) {
//            if (data != null) {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        context = this;
        movies = new ArrayList<>();
        movieViews = new ArrayList<>();
        movieListView = findViewById(R.id.list_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addMovieIntent = new Intent(context, AddNewMovie.class);
                startActivityForResult(addMovieIntent, ADD_IMAGE_REQUEST);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        if(movieListView!= null) {movieListView.removeAllViews();}
        for (TextView movieView : movieViews){
            movieListView.addView(movieView);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == ADD_IMAGE_REQUEST) {
            if (data != null) {
                MovieEntry newMovie = (MovieEntry) data.getSerializableExtra(MovieEntry.MOVIE_TAG);
                if (newMovie.getMovieName() != null) {
                    newMovie.setMovieId(movieIndex++);
                    movies.add(newMovie);
                    TextView newMovieView = createTextView(newMovie);
                    movieViews.add(newMovieView);
                }
            }
        }

        if(resultCode ==Activity.RESULT_OK && requestCode == EDIT_IMAGE_REQUEST){
            if (data != null) {
                MovieEntry editedMovie = (MovieEntry) data.getSerializableExtra(MovieEntry.MOVIE_TAG);
                movies.set(editedMovie.getMovieId(), editedMovie);
                TextView editedMovieView = createTextView(editedMovie);
                movieViews.set(editedMovie.getMovieId(), editedMovieView);
            }
        }
        if (resultCode == Activity.RESULT_CANCELED && requestCode == EDIT_IMAGE_REQUEST){
            if(data !=null){
                MovieEntry deletedMovie = (MovieEntry) data.getSerializableExtra(MovieEntry.MOVIE_TAG);
                movies.remove(deletedMovie.getMovieId());
                movieViews.remove(deletedMovie.getMovieId());
                for (int i = deletedMovie.getMovieId(); i < movies.size(); i++) {
                    movies.get(i).setMovieId(i);
                }}

        }
    }





    private TextView createTextView(final MovieEntry movie) {
        TextView movieView = new TextView(context);
        movieView.setText(movie.getMovieName());
        if (movie.isWatched()) {
            movieView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        } else { movieView.setTextColor(getResources().getColor(android.R.color.holo_red_dark)); }
        movieView.setTextSize(30);
        movieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(context, AddNewMovie.class);
                editIntent.putExtra(MovieEntry.MOVIE_TAG, movie);
                startActivityForResult(editIntent, EDIT_IMAGE_REQUEST);
            }
        });
        return movieView;
    }
}
