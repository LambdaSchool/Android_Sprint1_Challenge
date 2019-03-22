package com.lambdaschool.android_sprint1_challenge;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Intent intent = getIntent();
        final Movie movieToAdd = (Movie) intent.getSerializableExtra("movie");

        LinearLayout linearLayout = findViewById(R.id.linear_layout_movies);
        //final TextView addTextView = new TextView(this);

        if (movieToAdd != null) {
            Movie.movieList.add(movieToAdd);
        }

        if (Movie.movieList.size() > 0) {
            for (Movie movie : Movie.movieList) {
                addTextViewToLinearLayout(movie, linearLayout, new TextView(this));
                Movie.movieList.add(movie);
            }
        }



        Button buttonAddMovie = findViewById(R.id.button_add_movie);
        buttonAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MovieEdit.class);
                intent.putExtra("movie", new Movie());
                startActivity(intent);
            }
        });
    }

    private void addTextViewToLinearLayout(Movie movieToAdd, LinearLayout linearLayout, final TextView addTextView) {
        addTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        addTextView.setText(movieToAdd.getMovieTitle());
        addTextView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        if (movieToAdd.isWatched())
            addTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        addTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = new Movie(addTextView.getText().toString(), addTextView.getPaint().isStrikeThruText());
                Movie.movieList.remove(movie);
                Intent intent = new Intent(getApplicationContext(), MovieEdit.class);
                intent.putExtra("movie", movie);
                startActivity(intent);
            }
        });

        linearLayout.addView(addTextView);
    }
}
