package com.example.israel.sprint1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout movieListLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListLinearLayout = findViewById(R.id.linear_layout_movie_list);

        // create dummy movies
        createTextView(new Movie("Dino", true));
        createTextView(new Movie("Dragon", false));

    }

    private void createTextView(Movie movie) {
        TextView newTextView = new TextView(this);
        newTextView.setTag(movie);
        newTextView.setText(movie.getName());
        newTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25.f);
        // draw a strike-through if this movie has been watched
        if (movie.isWatched()) {
            // @TODO
        }

        movieListLinearLayout.addView(newTextView);

    }
}
