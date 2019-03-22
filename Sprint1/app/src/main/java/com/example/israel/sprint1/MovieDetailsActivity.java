package com.example.israel.sprint1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MovieDetailsActivity extends AppCompatActivity {

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();

        movie = (Movie)intent.getSerializableExtra(MovieListActivity.MOVIE_KEY);

        // adding a movie
        if (movie == null) {
            movie = new Movie("", false);
        }

        EditText movieNameEditText = findViewById(R.id.edit_text_movie_name);
        movieNameEditText.setText(movie.getName());
        movieNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                movie.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Switch isWatchedSwitch = findViewById(R.id.switch_is_watched);
        isWatchedSwitch.setChecked(movie.isWatched());
        isWatchedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                movie.setWatched(isChecked);
            }
        });

        Button deleteButton = findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // no need to send back anything since we're just deleting
                setResult(MovieListActivity.RESULT_CODE_MOVIE_EDIT_DELETE);
                finishActivity(MovieListActivity.REQUEST_CODE_MOVIE_EDIT);
                finish();

            }
        });

        Button saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // return the edited/added movie
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MovieListActivity.MOVIE_KEY, movie);
                setResult(MovieListActivity.RESULT_CODE_MOVIE_EDIT_SAVE, resultIntent);
                finishActivity(MovieListActivity.REQUEST_CODE_MOVIE_EDIT);
                finish();
            }
        });

    }
}
