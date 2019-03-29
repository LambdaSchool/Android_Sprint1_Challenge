package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;

public class ButtonsPage extends AppCompatActivity {

    public static final int NEW_ENTRY_REQUEST = 1;
    private Switch watchedOrNo;
    private Button deleteMovie;
    private EditText movieName;
    Context context;
    private Button saveMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_page);

        context= this;
        watchedOrNo = findViewById(R.id.iWatchedThisMovie);
        watchedOrNo.setChecked(false);

        movieName = findViewById(R.id.editMovie);

        deleteMovie = findViewById(R.id.deleteButton);
        saveMovie = findViewById(R.id.saveButton);

        saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);
                MovieEntry entry = createMovieEntry();
                intent.putExtra(MovieEntry.TAG, entry);
                startActivityForResult(intent, NEW_ENTRY_REQUEST);
            }

        });
    }

    private MovieEntry createMovieEntry() {
        MovieEntry entry = new MovieEntry(movieName.toString());
        return entry;
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
