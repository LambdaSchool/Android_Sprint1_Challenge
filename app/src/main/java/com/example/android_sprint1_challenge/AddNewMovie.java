package com.example.android_sprint1_challenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddNewMovie extends AppCompatActivity implements Serializable {
    private MovieEntry movie;
    private EditText movieTitleEntry;
    private Switch watchedSwitch;
    private Button saveButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_movie);

        movieTitleEntry = findViewById(R.id.movie_edit_text);
        watchedSwitch = findViewById(R.id.watched_switch);
        saveButton = findViewById(R.id.button_save);
        deleteButton = findViewById(R.id.button_delete);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if (intent.hasExtra(MovieEntry.MOVIE_TAG)) {
            movie = (MovieEntry) intent.getSerializableExtra(MovieEntry.MOVIE_TAG);
            movieTitleEntry.setText(movie.getMovieName());
            watchedSwitch.setChecked(movie.isWatched());
        } else {
            movie = new MovieEntry();
        }

        movieTitleEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String name = s.toString();
                movie.setMovieName(name);
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSavePressed(movie);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveIntent = new Intent();
                saveIntent.putExtra(MovieEntry.MOVIE_TAG,  movie);
                setResult(Activity.RESULT_CANCELED, saveIntent);
                finish();
            }
        });
    }

    protected void onSavePressed(MovieEntry movie) {
        if (movie != null) {
            movie.setWatched(watchedSwitch.isChecked());
            Intent saveIntent = new Intent();
            saveIntent.putExtra(MovieEntry.MOVIE_TAG,  movie);
            setResult(Activity.RESULT_OK, saveIntent);
            finish();
        } else { onBackPressed(); }
    }
}