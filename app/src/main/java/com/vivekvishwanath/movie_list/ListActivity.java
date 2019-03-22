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

public class ListActivity extends AppCompatActivity {
    Context context;
    LinearLayout movieListView;
    Button addMovieButton;
    private int watchedColor = android.R.color.holo_green_dark;
    private int unwatchedColor = android.R.color.holo_red_dark;

    public static final int ADD_IMAGE_REQUEST = 2;
    public static final int EDIT_IMAGE_REQUEST =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        context = this;

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

            }
        }
    }

    private TextView createMovieView(final Movie movie) {
        TextView movieView = new TextView(context);
        movieView.setText(movie.getMovieTitle());
        movieView.setTextColor(movie.isWatched() ?
                getResources().getColor(watchedColor)
                : getResources().getColor(unwatchedColor) );
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
