package com.example.patrickjmartin.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.lambdaschool.movieslist.R;

public class AddDetails extends AppCompatActivity {


    public static final String EDIT_MOVIE_KEY = "edit_movie";

    private Movie movie;
    private Switch watchSwitch;
    private Context context;
    private EditText movieTitle;
    private Button deleteMovie, saveMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        deleteMovie = findViewById(R.id.button_delete);
        saveMovie = findViewById(R.id.button_save);

        movie = (Movie) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        


    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent =  getIntent();

    }
}