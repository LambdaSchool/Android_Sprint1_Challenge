package com.example.android_sprint1_challenge;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class editList extends AppCompatActivity {

    EditText addMovie;
    AppCompatCheckBox checkWatched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addMovie = findViewById(R.id.add_movie);
        checkWatched = findViewById(R.id.check_watched);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int index = 0;
                movieModel movie;
                movie = new movieModel(index++,addMovie.getText().toString(),checkWatched.isChecked());



            }
        });
    }

}
