package com.example.patrickjmartin.android_sprint1_challenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.lambdaschool.movieslist.R;

public class AddDetails extends AppCompatActivity {


    public static final String EDIT_MOVIE_KEY = "edit_movie";

    private Movie movie;
    private Switch watchSwitch;
    private EditText movieTitle;
    private Button deleteMovie, saveMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        movieTitle = findViewById(R.id.editText);
        deleteMovie = findViewById(R.id.button_delete);
        saveMovie = findViewById(R.id.button_save);
        watchSwitch = findViewById(R.id.switch1);


        movie = (Movie) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        if(movie == null){
            movie = new Movie(Movie.NO_ID);
        }
        movieTitle.setText(movie.getTitle());
        watchSwitch.setChecked(movie.isWatched());
    }



    @Override
    protected void onResume() {
        super.onResume();

        saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setTitle(movieTitle.getText().toString());
                movie.setWatched(watchSwitch.isChecked());
                Intent editIntent = new Intent();
                editIntent.putExtra(EDIT_MOVIE_KEY, movie);
                setResult(Activity.RESULT_OK, editIntent);
                finish();
            }
        });

        deleteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setId(Movie.NO_ID);
                finish();
            }
        });

    }
}