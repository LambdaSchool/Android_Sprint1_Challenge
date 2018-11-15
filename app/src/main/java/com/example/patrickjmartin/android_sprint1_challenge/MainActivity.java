package com.example.patrickjmartin.android_sprint1_challenge;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
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
                Intent intent = new Intent(context, AddDetails.class);
                Movie movie = null;
                intent.putExtra(AddDetails.EDIT_MOVIE_KEY, movie);
                startActivityForResult(intent, EDIT_MOVIE_REQUEST_CODE);
            }
        });
    }

    private TextView getDefaultTextView(MovieOverview movie) {
        TextView view = new TextView(context);
        final String releaseYear = movie.getRelease_date().split("-")[0];
        String displayText = String.format("%s (%s)", movie.getTitle(), releaseYear);

        view.setText(displayText);
        view.setTextSize(28);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int id = movie.getId();
                //Log.i("MovieElement", Integer.toString(id));
            }
        });

        return view;
    }

    private void refreshListView(ArrayList<Movie> movies) {
        layoutList.removeAllViews();
        for (Movie movie : movies) {
            //layoutList.addView(getDefaultTextView(movie));
        }
    }
}
