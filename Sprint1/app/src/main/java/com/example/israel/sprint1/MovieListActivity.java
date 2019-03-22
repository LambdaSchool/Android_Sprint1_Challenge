package com.example.israel.sprint1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieListActivity extends AppCompatActivity {

    public static final String MOVIE_KEY = "movie";

    private LinearLayout movieListLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListLinearLayout = findViewById(R.id.linear_layout_movie_list);

        Button addMovieButton = findViewById(R.id.button_add_movie);
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieListActivity.this, MovieDetailsActivity.class);
                // adding a movie
                startActivity(intent);

            }
        });

        // create dummy movies
        createTextView(new Movie("Dino", true));
        createTextView(new Movie("Dragon", false));

    }

    private void createTextView(final Movie movie) {
        TextView newTextView = new TextView(this);
        newTextView.setTag(movie);
        newTextView.setText(movie.getName());
        newTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25.f);
        // draw a strike-through if this movie has been watched
        if (movie.isWatched()) {
            // @TODO
        }

        movieListLinearLayout.addView(newTextView);

        newTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieListActivity.this, MovieDetailsActivity.class);
                intent.putExtra(MOVIE_KEY, movie);
                startActivity(intent);

                // remove the textView
                ViewGroup viewGroup = (ViewGroup)v.getParent();
                viewGroup.removeView(v);
            }
        });

    }
}
