package com.example.android_sprint1_challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

class MainActivity extends AppCompatActivity {

    private MovieEntry entry;

    private EditText entryMovieName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.add_movie);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                entry = (MovieEntry) intent.getSerializableExtra(MovieEntry.TAG);
                if(entry == null) {
                    entry = new MovieEntry(MovieEntry.INVALID_ID);
                }
            }
        });




    }


}