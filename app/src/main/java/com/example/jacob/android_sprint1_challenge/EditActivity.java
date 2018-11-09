package com.example.jacob.android_sprint1_challenge;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    public static final String EDIT_MOVIE_KEY = "edit_movie";
    private Context context;
    EditText editTitle;
    Switch switchWatched;
    Movie movie;
    private MovieViewModel viewModel;

    public static final int DELETE_REQUEST_CODE = 1;
    public static final int SAVE_REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        context = this;
        editTitle = findViewById(R.id.edit_title);
        switchWatched = findViewById(R.id.switch_watched);
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        editTitle.requestFocus();

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
                onBackPressed();
//                prepResult();
//                Intent intent = new Intent(context, MainActivity.class);
//                startActivityForResult(intent, SAVE_REQUEST_CODE);
            }
        });

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra(EditActivity.EDIT_MOVIE_KEY, movie);
                startActivityForResult(intent, DELETE_REQUEST_CODE);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == DELETE_REQUEST_CODE) {
                if (data != null) {
                    Movie returnedMovie = (Movie) data.getSerializableExtra(EditActivity.EDIT_MOVIE_KEY);
                    viewModel.deleteMovie(returnedMovie);
                }
            } else if (resultCode == SAVE_REQUEST_CODE) {
                prepResult();
                onBackPressed();
            }
        }
    }


    @Override
    public void onBackPressed() {
        prepResult();
        super.onBackPressed();
    }


    private void prepResult() {
        movie.setTitle(editTitle.getText().toString());
        movie.setWatched(switchWatched.isChecked());
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
        setResult(Activity.RESULT_OK, resultIntent);
    }
}