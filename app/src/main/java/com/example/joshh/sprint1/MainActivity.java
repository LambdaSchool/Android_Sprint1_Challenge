package com.example.joshh.sprint1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int EDIT_MOVIE_REQUEST_CODE = 1;
    private Context             context;
    private LinearLayout        ll;
    private Button              addMovieButton;
    private MovieViewModel      viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll              =    findViewById(R.id.scroll_view_layout);
        addMovieButton  =    findViewById(R.id.add_movie_button);
        context         =    this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewModel =ViewModelProviders.of(this).get(MovieViewModel.class);
        final Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Movie> movies) {
                if(movies != null){
                    refreshListView(movies);
                }
            }
        };
        viewModel.getMovieList().observe(this, observer);

        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                Movie newMovie = new Movie(Movie.NO_ID);
                intent.putExtra(EditActivity.EDIT_MOVIE_KEY, newMovie);
                startActivityForResult(intent, EDIT_MOVIE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == EDIT_MOVIE_REQUEST_CODE){
                if(data != null){
                    Movie returnedMovie = (Movie) data.getSerializableExtra(EditActivity.EDIT_MOVIE_KEY);
                    viewModel.addMovie(returnedMovie);
                }
            }
        }
    }

    private void refreshListView(ArrayList<Movie> movies){
        ll.removeAllViews();
        for(Movie m : movies){
            ll.addView(createDefaultTextView(m));
        }
    }

    private TextView createDefaultTextView(final Movie movie){
        TextView tv = new TextView(context);
        tv.setTextSize(30);
        tv.setWidth(368);
        tv.setPadding(55, 0, 0, 0);
        tv.setTextColor(Color.BLACK);
        tv.setText(movie.getTitle());
        if(movie.isWatched()){
            tv.setTextColor(Color.GREEN);
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        return tv;
    }
}
