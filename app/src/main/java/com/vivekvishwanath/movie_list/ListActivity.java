package com.vivekvishwanath.movie_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ListActivity extends AppCompatActivity {
    Context context;
    LinearLayout movieListView;
    Button addMovieButton;

    public static final int ADD_IMAGE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        context = this;

        addMovieButton = findViewById(R.id.add_movie_button);
        movieListView = findViewById(R.id.movie_list_view);

        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovieIntent = new Intent(context, EditActivity.class);
                startActivityForResult(addMovieIntent, ADD_IMAGE_REQUEST);
            }
        });
    }


}
