package com.rybarstudios.movielist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.io.Serializable;
import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    Movie movieEntry;
    private Switch watchedSwitch;
    private EditText mEditText;
    private Button deleteMovie, saveMovie;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        context = this;

        deleteMovie = findViewById(R.id.delete_button);
        saveMovie = findViewById(R.id.save_button);

        Intent intent = getIntent();
        movieEntry = (Movie) intent.getSerializableExtra(Movie.TAG);
        if(movieEntry == null) {
            movieEntry = new Movie(Movie.INVALID_ID);
        }

        watchedSwitch = findViewById(R.id.switch1);
        mEditText = findViewById(R.id.editText);

        mEditText.setText(movieEntry.getTitle());
        watchedSwitch.setChecked(movieEntry.isWatched());

        /*((Button)findViewById(R.id.save_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*movieEntry.setTitle(movieName);
                movieEntry.setWatched(watched);*//*

                Intent resultIntent = new Intent();
                resultIntent.putExtra(Movie.TAG, movieEntry);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        ((Button)findViewById(R.id.delete_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent resultIntent = new Intent();
                resultIntent.putExtra(Movie.TAG, movieEntry);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });*/

    }

    @Override
    protected void onResume() {
        super.onResume();

        saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieEntry.setTitle(mEditText.getText().toString());
                movieEntry.setWatched(watchedSwitch.isChecked());
                Intent editIntent = new Intent();
                editIntent.putExtra(Movie.TAG, movieEntry);
                setResult(Activity.RESULT_OK, editIntent);
                finish();
            }
        });

        deleteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieEntry.setId(Movie.INVALID_ID);
                Intent edit = new Intent(context, MainActivity.class);
                edit.putExtra(Movie.TAG, movieEntry);
                startActivity(edit);
                finish();
            }
        });

    }

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == MainActivity.EDIT_REQUEST_CODE) {
            if(data != null) {
                Movie movieEntry = (Movie) data.getSerializableExtra(Movie.TAG);
                movieEntry.setWatched(movieEntry.isWatched());
                movieEntry.setTitle(movieEntry.getTitle());
            }
        }
    }*/
}
