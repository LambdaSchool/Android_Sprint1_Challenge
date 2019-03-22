package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;

public class DetailsView extends AppCompatActivity {
    ArrayList<MovieData> movieList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        context = this;

        Button buttonSave = findViewById(R.id.button_save);
        Button buttonDelete = findViewById(R.id.button_delete);
        final Switch switchWatched = findViewById(R.id.switch_watched);
        final EditText editTextTitle = findViewById(R.id.edit_text_title);

        Intent intent = getIntent();
        movieList = (ArrayList)intent.getSerializableExtra("movieList");


      //  if (switchWatched.isChecked()) {}

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieData temp;
                temp = new MovieData(
                        editTextTitle.getText().toString(),
                        switchWatched.isChecked(),
                        movieList.size()
                );
                movieList.add (temp);
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("movieList", movieList);
                startActivity(intent);

            }
        });
    }
}
