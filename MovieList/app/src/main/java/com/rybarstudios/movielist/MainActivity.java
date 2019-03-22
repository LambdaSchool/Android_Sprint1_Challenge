package com.rybarstudios.movielist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final int MOVIE_REQUEST_CODE = 50;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;


        ((Button)findViewById(R.id.button_add_movie)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                Movie movie = new Movie(Movie.INVALID_ID);
                intent.putExtra(EditActivity.MOVIE_KEY, movie);
                startActivityForResult(intent, MOVIE_REQUEST_CODE);
            }
        });
    }

    private TextView genTextView(Movie movie) {
        TextView view = new TextView(context);
        view.setText(movie.getTitle());
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

        if(movie.isWatched()) {
            view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        return view;
    }
}
