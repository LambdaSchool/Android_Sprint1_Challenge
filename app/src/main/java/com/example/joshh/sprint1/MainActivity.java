package com.example.joshh.sprint1;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int EDIT_MOVIE_REQUEST_CODE = 2;
    private Context             context;
    private LinearLayout        ll;
    private Button              addMovieButton;
    private MovieViewModel      viewModel;
    private FloatingActionButton fab;
    private int themeId;
    private Activity activity;
    public static SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = this.getPreferences(Context.MODE_PRIVATE);
        ll              =    findViewById(R.id.scroll_view_layout);
        addMovieButton  =    findViewById(R.id.add_movie_button);
        fab             =    findViewById(R.id.floating_action_button);
        context         =    this;
        activity = this;
    }

    @Override
    public void setTheme(int resid) {
        themeId = resid;
        super.setTheme(resid);

    }

    @Override
    protected void onStart() {
        if(!ThemeUtils.checkTheme(activity, themeId)){
            ThemeUtils.refreshActivity(activity);
        }
        super.onStart();
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SettingsActivity.class);
                startActivity(intent);
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
        tv.setTextSize(getResources().getDimension(R.dimen.list_movie_text_size));
        tv.setWidth(getResources().getDimensionPixelOffset(R.dimen.list_movie_width));
        tv.setPadding(getResources().getDimensionPixelOffset(R.dimen.list_movie_padding_left), 0, 0, 0);
        tv.setTextColor(getResources().getColor(R.color.text_color));
        tv.setText(movie.getTitle());
        if(movie.isWatched()){
            tv.setTextColor(Color.GREEN);
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.removeMovie(movie);
                Intent editMovieIntent = new Intent(context, EditActivity.class);
                editMovieIntent.putExtra(EditActivity.EDIT_MOVIE_KEY, movie);
                startActivityForResult(editMovieIntent, EDIT_MOVIE_REQUEST_CODE);
            }
        });
        return tv;
    }
}
