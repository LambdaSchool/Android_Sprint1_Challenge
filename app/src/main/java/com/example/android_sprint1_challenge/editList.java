package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class editList extends AppCompatActivity {

    EditText addMovie;
    AppCompatCheckBox checkWatched;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context = this;
        addMovie = findViewById(R.id.add_movie);
        checkWatched = findViewById(R.id.check_watched);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent;
                int index = 0;
                movieModel movie;
                movie = new movieModel(index++,addMovie.getText().toString(),checkWatched.isChecked());

                intent = new Intent(context, MainActivity.class);
                intent.putExtra("movie", movie);
                startActivity(intent);
            }
        });
    }

}
