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
    private int nextid = 0;
    private Context context = this;
    private EditText movieEntry;
    private Button buttonSave, buttonDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movieEntry = findViewById(R.id.movie_entry);

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


    }


}
