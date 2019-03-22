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
    int index;

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
        //checks if you came here by way of the list, or the button
        final int index = (int) intent.getSerializableExtra("index");
        if (index != -1) {
            MovieData temp = movieList.get(index);

            //populating view if you came here via list
            editTextTitle.setText(temp.getTitle());
            switchWatched.setChecked(temp.isWatched());
        }




        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieData temp;
                temp = new MovieData(
                        editTextTitle.getText().toString(),
                        switchWatched.isChecked(),
                        movieList.size()
                );
                if (index != -1) { //execute if it's a previously saved movie
                    movieList.set(index,temp);
                }
                else { //execute if it's a new movie
                    movieList.add(temp);
                }
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("movieList", movieList);
                    startActivity(intent);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index != -1){
                    movieList.remove(index);
                }
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("movieList", movieList);
                startActivity(intent);
            }
        });
    }
}
