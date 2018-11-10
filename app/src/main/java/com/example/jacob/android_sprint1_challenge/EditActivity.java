package com.example.jacob.android_sprint1_challenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    public static final String EDIT_MOVIE_KEY = "edit_movie";
    EditText editTitle;
    Switch switchWatched;
    Movie movie;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTitle = findViewById(R.id.edit_title);
        switchWatched = findViewById(R.id.switch_watched);
        context = this;

        movie = (Movie) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        if (movie == null) {
            movie = new Movie(Movie.NO_ID);
            movie.setTitle("");
            movie.setWatched(false);
        } else {
            editTitle.setText(movie.getTitle());
            switchWatched.setChecked(movie.getWatched());
        }

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKeyboard(context);
                movie.setTitle(editTitle.getText().toString());
                movie.setWatched(switchWatched.isChecked());
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKeyboard(context);
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
                setResult(Constants.DELETE_RESULT_CODE, resultIntent);
                finish();
            }
        });
        editTitle.requestFocus();
        showKeyboard(context);
    }

    public static void showKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }

}