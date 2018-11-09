package com.example.jacob.android_sprint1_challenge;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    public static final String EDIT_MOVIE_KEY = "edit_movie";

    EditText editTitle;
    Switch switchWatched;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTitle = findViewById(R.id.edit_title);
        switchWatched = findViewById(R.id.switch_watched);

        movie = (Movie) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        movie = new Movie(Movie.NO_ID);
/*        if (movie == null) {
            movie = new Movie(Movie.NO_ID);
        } else {
            editTitle.setText(movie.getTitle());
            switchWatched.setChecked(movie.getWatched());
        }*/



    }

    @Override
    public void onBackPressed() {
        // must set result here
        prepResult();
        super.onBackPressed();
    }

    // setting result in onPause doesn't work because the result code is set to 0 before
    // finish() is called, and finish() is called before onPause() is called
    /*@Override
    protected void onPause() {
        super.onPause();
        prepResult();
    }*/


    private void prepResult() {
        movie.setTitle(editTitle.getText().toString());
        movie.setWatched(switchWatched.isChecked());
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
        setResult(Activity.RESULT_OK, resultIntent);
    }
}