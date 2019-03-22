package com.example.patrickjmartin.android_sprint1_challenge;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lambdaschool.movieslist.R;
import com.lambdaschool.movieslist.apiaccess.MovieOverview;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutList;
    MovieViewModel viewModel;
    Context context;
    public static final int EDIT_MOVIE_REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layout_list);
        context = this;

        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        final Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Movie> movies) {
                if (movies != null) {
                    refreshListView(movies);
                }
            }
        };

        viewModel.getOverViewList().observe(this, observer);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovieIntent = new Intent(context, AddDetails.class);
                Movie movie = new Movie(Movie.NO_ID);
                addMovieIntent.putExtra(AddDetails.EDIT_MOVIE_KEY, movie);
                startActivityForResult(addMovieIntent, EDIT_MOVIE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if(requestCode == EDIT_MOVIE_REQUEST_CODE ) {
                if(data != null) {
                    Movie retMovie = (Movie) data.getSerializableExtra(AddDetails.EDIT_MOVIE_KEY);
                    viewModel.addMovie(retMovie);
                }
            }
        }
    }

    private TextView getDefaultTextView(final Movie movie) {
        TextView textView = new TextView(context);
        textView.setText(movie.getTitle());
        boolean watched = movie.isWatched();

        if (watched) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        textView.setTextSize(24);
        textView.setPadding(10, 10, 10, 10);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.removeMovie(movie);
                Intent editMovieIntent = new Intent(context, AddDetails.class);
                editMovieIntent.putExtra(AddDetails.EDIT_MOVIE_KEY, movie);
                startActivityForResult(editMovieIntent, EDIT_MOVIE_REQUEST_CODE);

            }
        });
        return textView;
    }

    private void refreshListView(ArrayList<Movie> movies) {
        layoutList.removeAllViews();
        for (Movie movie : movies) {
            layoutList.addView(getDefaultTextView(movie));
        }
    }
}
