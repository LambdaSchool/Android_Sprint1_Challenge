package com.vivekvishwanath.movie_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    Context context;
    LinearLayout movieListView;
    Button addMovieButton;
    private int watchedColor = android.R.color.holo_green_dark;
    private int unwatchedColor = android.R.color.holo_red_dark;

    public static final int ADD_IMAGE_REQUEST = 2;
    public static final int EDIT_IMAGE_REQUEST =3;

    private ArrayList<Movie> movies;
    private ArrayList<TextView> movieViews;

    private int currentIndex;

    private int movieIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        context = this;

        movies = new ArrayList<>();
        movieViews = new ArrayList<>();

        addMovieButton = findViewById(R.id.add_movie_button);
        movieListView = findViewById(R.id.movie_list_view);

        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovieIntent = new Intent(context, EditActivity.class);
                startActivityForResult(addMovieIntent, ADD_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == ADD_IMAGE_REQUEST) {
            if (data != null) {
                Movie newMovie = (Movie) data.getSerializableExtra(Movie.MOVIE_TAG);
                if (newMovie.getMovieTitle() != null) {
                    newMovie.setMovieId(movieIndex++);
                    movies.add(newMovie);
                    TextView newMovieView = createMovieView(newMovie);
                    movieListView.addView(newMovieView);
                    movieViews.add(newMovieView);
                }
            }
        }

        if (resultCode == Activity.RESULT_OK && requestCode == EDIT_IMAGE_REQUEST) {
            if (data != null) {
                Movie movie = (Movie) data.getSerializableExtra(Movie.MOVIE_TAG);
                movies.set(movie.getMovieId(), movie);
                movieViews.get(movie.getMovieId()).setText(movie.getMovieTitle());
                movieViews.set(movie.getMovieId(), createMovieView(movie));
            }
        }
    }

    private TextView createMovieView(final Movie movie) {
        TextView movieView = new TextView(context);
        movieView.setText(movie.getMovieTitle());
        if (movie.isWatched()) {
            movieView.setTextColor(getResources().getColor(watchedColor));
        } else { movieView.setTextColor(getResources().getColor(unwatchedColor)); }
        movieView.setTextSize(20);
        movieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(context, EditActivity.class);
                editIntent.putExtra(Movie.MOVIE_TAG, movie);
                startActivityForResult(editIntent, EDIT_IMAGE_REQUEST);
            }
        });
        return movieView;
    }
}

