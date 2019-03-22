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

public class MovieDeltails extends AppCompatActivity implements Serializable {
    EditText editText;
    Switch viewedSwitch;
    Button saveButton, deleteButton;
    String movieName;
    Context context = this;

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
                Intent saveMovies = new Intent(context, MainActivity.class);
                Boolean switchViewed = viewedSwitch.isChecked();
                saveMovies.putExtra("movieName", movieName);
                saveMovies.putExtra("watched", switchViewed);
                startActivity(saveMovies);

            }
        });








    }
}