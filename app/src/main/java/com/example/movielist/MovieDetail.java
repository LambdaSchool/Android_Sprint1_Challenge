package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetail extends AppCompatActivity {

    private MovieModel entry;

    private Context context = this;
    private EditText movieEntry;
    private Button buttonSave, buttonDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        entry = (MovieModel) intent.getSerializableExtra("entry");

        movieEntry = findViewById(R.id.movie_entry);
        movieEntry.setText(entry.getMovieName());

        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieListActivity.class);
                String entry = String.valueOf(movieEntry.getText());
                intent.putExtra("entry",entry);
                startActivity(intent);
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



