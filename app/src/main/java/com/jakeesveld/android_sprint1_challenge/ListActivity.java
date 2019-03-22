package com.jakeesveld.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    LinearLayout layoutList;
    Button buttonAdd;
    Context context;
    public final int MOVIE_REQUEST_CODE = 1;
    static int movieId = 0;
    ArrayList<Movies> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);
        context = this;

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                Movies movie = createNewMovie(movieId++);
                intent.putExtra("movie", movie);
                startActivityForResult(intent, MOVIE_REQUEST_CODE);
            }
        });
    }

    public Movies createNewMovie(int id){
        Movies newMovie = new Movies(id);

        return newMovie;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == MOVIE_REQUEST_CODE) {
            Movies movie = (Movies) data.getSerializableExtra("movie");
            if(data.getBooleanExtra("add", true)){
                moviesList.add(movie);
            }else{
                for(Movies selectedMovie: moviesList){
                    if (selectedMovie.getTitle().equals(selectedMovie.getTitle())){
                        moviesList.remove(selectedMovie);
                    }
                }
            }
        }
    }
}
