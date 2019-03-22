package com.example.android_sprint1_challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

class MainActivity extends AppCompatActivity {

    private MovieEntry entry;

    private EditText entryMovieName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        entry = (MovieEntry) intent.getSerializableExtra(MovieEntry.TAG);
        if(entry == null) {
            entry = new MovieEntry(MovieEntry.INVALID_ID);
        }


    }


}