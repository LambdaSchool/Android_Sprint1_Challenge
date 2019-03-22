package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Context context;
    final ArrayList<movieModel> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_button);
        context = this;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent  intent = new Intent(context, editList.class);
                startActivity(intent);

            }

        });

        Intent finalIntent = getIntent();
        movieModel serialisedMovieIntent = (movieModel) finalIntent.getSerializableExtra("movie");

        movies.add(serialisedMovieIntent);






    }


}
