package com.example.jacob.android_sprint1_challenge;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Paint;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private LinearLayout layoutList;
    private MovieViewModel viewModel;

    public static final int EDIT_REQUEST_CODE = 2;
    public static final int DELETE_REQUEST_CODE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        layoutList = findViewById(R.id.layout_list);

        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        final Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Movie> movies) {
                if (movies != null) {
                    refreshListView(movies);
                }

            }
        };
        viewModel.getMovieList().observe(this, observer);

        findViewById(R.id.button_addmovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditActivity.class);
                Movie newMovie = null;
                intent.putExtra(EditActivity.EDIT_MOVIE_KEY, newMovie);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });
    }

    private TextView getDefaultTextView(final Movie movie) {
        TextView textView = new TextView(context);
        textView.setText(movie.getTitle());
        boolean watched = movie.getWatched();
        if (watched == true) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        textView.setTextSize(24);
        textView.setPadding(10, 10, 10, 10);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra(EditActivity.EDIT_MOVIE_KEY, movie);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == EDIT_REQUEST_CODE) {
                if (data != null) {
                    Movie returnedMovie = (Movie) data.getSerializableExtra(EditActivity.EDIT_MOVIE_KEY);
                    viewModel.addMovie(returnedMovie);
                }
            }
        }  else if (resultCode == Constants.DELETE_RESULT_CODE) {
            if (data != null) {
                Movie returnedMovie = (Movie) data.getSerializableExtra(EditActivity.EDIT_MOVIE_KEY);
                viewModel.deleteMovie(returnedMovie);
            }
        }
    }
}
