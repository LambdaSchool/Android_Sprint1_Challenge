package com.vivekvishwanath.movie_list;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    private Movie movie;
    private EditText movieTitleEntry;
    private Switch watchedSwitch;
    private Button saveButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        movieTitleEntry = findViewById(R.id.movie_title_entry);
        watchedSwitch = findViewById(R.id.watched_switch);
        saveButton = findViewById(R.id.save_button);
        deleteButton = findViewById(R.id.delete_button);

    }

    @Override
    protected void onResume() {
        super.onResume();
        movie = new Movie();

        movieTitleEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                movie.setMovieTitle(s.toString());
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSavePressed(movie);
            }
        });
    }

    protected void onSavePressed(Movie movie) {
        if (movie != null) {
            movie.setWatched(watchedSwitch.isChecked());
            Intent saveIntent = new Intent();
            saveIntent.putExtra(Movie.MOVIE_TAG, movie);
            setResult(Activity.RESULT_OK, saveIntent);
            finish();
        }
    }
}
