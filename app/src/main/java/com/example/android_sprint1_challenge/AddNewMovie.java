package com.example.android_sprint1_challenge;

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

public class AddNewMovie extends AppCompatActivity implements Serializable {
    private EditText movieInput;
    private Button saveButton, deleteButton;
    private Switch viewedSwitch;
    //private Boolean switchViewed;
    Context context;
    private MovieEntry entry;
    private String entryString;
    private ArrayList<MovieEntry> entryList ;
    Boolean switchViewed;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_movie);
        viewedSwitch = findViewById(R.id.watched_switch);
        movieInput = findViewById(R.id.movie_edit_text);
        saveButton = findViewById(R.id.button_save);
        deleteButton = findViewById(R.id.button_delete);
    }

    @Override
    protected void onResume() {
        super.onResume();
         Intent passList;
        context = this;
        passList = getIntent();
            if (passList.getStringExtra("textmovieName") != null) {
                String movieName = passList.getStringExtra("textmovieName");
                id = passList.getIntExtra("textmovieId", 0);
                MovieRepo.allMovies.remove(id);
                MovieEntry editMovie = MovieRepo.allMovies.get(id);

                //                switchViewed = passList.getBooleanExtra("textmovieBoolean",false);
                viewedSwitch.setChecked(editMovie.getViewed());
                entryString = editMovie.getMovieName();
                movieInput.setText(entryString);        }




        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveIntent = new Intent(context, MovieListActivity.class);
                entryString = movieInput.getText().toString();
                MovieEntry addMovie = new MovieEntry(entryString, viewedSwitch.isChecked());
                MovieRepo.allMovies.add(addMovie);
                startActivity(saveIntent);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteIntent = new Intent(context, MovieListActivity.class);
                MovieRepo.allMovies.remove(id);
                startActivity(deleteIntent);
            }
        });



    }
}
