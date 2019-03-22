package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.ACTION_SEND;

class MovieActivity extends AppCompatActivity {


Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ((Button)findViewById(R.id.add_movie)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovieButton = new Intent(ACTION_SEND);
            }
        });
    }
}
