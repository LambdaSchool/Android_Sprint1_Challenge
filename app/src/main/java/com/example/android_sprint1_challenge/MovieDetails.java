package com.example.android_sprint1_challenge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MovieDetails extends AppCompatActivity {

    public static final int NEW_ENTRY_REQUEST = 1;
    private Switch aSwitch;
    private Button deleteMovie;
    private EditText movieName;
    private String movieNameString;
    Context context;
    private Button saveMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        context = this;
        aSwitch = findViewById(R.id.iWatchedThisMovie);
        aSwitch.setChecked(false);

        movieName = findViewById(R.id.editMovie);

        deleteMovie = findViewById(R.id.deleteButton);
        saveMovie = findViewById(R.id.saveButton);

        saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieNameString = movieName.getText().toString();

            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}