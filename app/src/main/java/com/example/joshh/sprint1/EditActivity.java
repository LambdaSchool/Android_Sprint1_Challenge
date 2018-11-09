package com.example.joshh.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    public static final String EDIT_MOVIE_KEY = "edit_movie";

    private LinearLayout buttonParent, titleSwitchParent;
    private Button       addMovie, deleteMovie;
    private Switch       watchedSwitch;
    private EditText     title;
    private Movie        movie;
    private MovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        buttonParent        = findViewById(R.id.button_parent);
        titleSwitchParent   = findViewById(R.id.title_swtich_parent);
        addMovie            = findViewById(R.id.save_movie_button);
        deleteMovie         = findViewById(R.id.delete_movie_button);
        watchedSwitch       = findViewById(R.id.watched_switch);
        title               = findViewById(R.id.movie_title);

        movie = (Movie) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        if(movie == null){
            movie = new Movie(Movie.NO_ID);
        }
        title.setText(movie.getTitle());
        watchedSwitch.setChecked(movie.isWatched());

    }

    @Override
    public void onBackPressed() {
        Result();
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result();
                finish();
            }
        });
        deleteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setId(Movie.NO_ID);
                finish();
            }
        });
    }

    private void Result(){
        movie.setTitle(title.getText().toString());
        movie.setWatched(watchedSwitch.isChecked());
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
        setResult(Activity.RESULT_OK, resultIntent);
    }



}
