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
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    public static final int EDIT_MOVIE_REQUEST_CODE = 2;
    LinearLayout layoutList;
    Button buttonAdd;
    Context context;
    public final int MOVIE_REQUEST_CODE = 1;
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
                Movies movie = new Movies();
                intent.putExtra("movie", movie);
                startActivityForResult(intent, MOVIE_REQUEST_CODE);
            }
        });

        moviesList = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        layoutList.removeAllViews();
            for (Movies allmovies : moviesList) {
                layoutList.addView(createMovieView(allmovies));

        }
    }

    private TextView createMovieView(final Movies movieView) {
        final TextView view = new TextView(context);
        view.setText(movieView.getTitle());
        view.setTextSize(22);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDetailIntent = new Intent(context, ListActivity.class);
                viewDetailIntent.putExtra("editMovie", movieView);
                startActivityForResult(viewDetailIntent, EDIT_MOVIE_REQUEST_CODE);
            }
        });

        layoutList.addView(view);
        return view;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == MOVIE_REQUEST_CODE) {
            Movies movie = (Movies) data.getSerializableExtra("movie");
            if((Boolean) data.getSerializableExtra("add")){
                moviesList.add(movie);
            }else if (!(Boolean) data.getSerializableExtra("add")){
                Movies returnedMovie = (Movies) data.getSerializableExtra("movie");
                for(Movies selectedMovie: moviesList){
                    if (selectedMovie.getTitle().equals(returnedMovie.getTitle())){
                        moviesList.remove(selectedMovie);
                    }
                }
            }
        }
    }
}
