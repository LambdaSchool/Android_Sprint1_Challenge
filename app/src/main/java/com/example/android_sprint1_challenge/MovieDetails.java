package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieDetails extends AppCompatActivity implements Serializable {
    EditText editText;
    Switch viewedSwitch;
    Button saveButton, deleteButton;
    String movieName;
    Context context = this;
    MovieRepo newRepo = new MovieRepo();
    ArrayList<MovieObject> movieObjectArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_deltails);

        editText = findViewById(R.id.movie_edit_text);
        viewedSwitch = findViewById(R.id.watched_switch);
        saveButton = findViewById(R.id.button_save);
        deleteButton = findViewById(R.id.button_delete);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                movieName = s.toString();

            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getData = getIntent();
//                int movieIndex = (Integer)getData.getSerializableExtra("index");

                Intent saveMovies = new Intent(MovieDetails.this , MainActivity.class);


                MovieObject addThisMovie = new MovieObject();

                Boolean switchViewed = viewedSwitch.isChecked();
                addThisMovie.setViewed(switchViewed);
                addThisMovie.setMovieName(movieName);
//                addThisMovie.setIndexValue(movieIndex);

                saveMovies.putExtra("newmovie", addThisMovie);
                saveMovies.putExtra("movieName", movieName);
                saveMovies.putExtra("watched", switchViewed);
                movieObjectArrayList.add(addThisMovie);
                startActivity(saveMovies);

            }
        });








    }
}