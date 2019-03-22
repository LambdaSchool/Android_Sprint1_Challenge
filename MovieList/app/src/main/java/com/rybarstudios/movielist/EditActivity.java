package com.rybarstudios.movielist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        context = this;

        Intent intent = getIntent();
        movieEntry = (Movie) intent.getSerializableExtra(Movie.TAG);
        if(movieEntry == null) {
            movieEntry = new Movie(Movie.INVALID_ID);
        }

        watchedSwitch = findViewById(R.id.switch1);
        mEditText = findViewById(R.id.editText);

        ((Button)findViewById(R.id.save_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName = mEditText.getText().toString();
                boolean watched = watchedSwitch.isChecked();
                movieEntry.setTitle(movieName);
                movieEntry.setWatched(watched);

                Intent resultIntent = new Intent();
                resultIntent.putExtra(Movie.TAG, movieEntry);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        ((Button)findViewById(R.id.delete_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieEntry.setId(Movie.INVALID_ID);
                finish();
            }
        });

    }
}
