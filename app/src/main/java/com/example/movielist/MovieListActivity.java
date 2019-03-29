package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    public static final int NEW_ENTRY_REQUEST_CODE = 4;
    static int nextid = 0;
    MovieModel entry;
    Context context = this;
    ScrollView movieListView;
    LinearLayout interListView;
    private ArrayList<MovieModel> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);

        Intent intent = getIntent();
        entry = (MovieModel) intent.getSerializableExtra(MovieModel.TAG);
        if(entry == null){
            entry = new MovieModel(MovieModel.INVALD_ID);

        }

        interListView = findViewById(R.id.inter_listView);

        movieListView = findViewById(R.id.movie_listView);
        findViewById(R.id.add_movie_to_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieDetail.class);
                MovieModel entry = createMovieEntry();
                intent.putExtra(MovieModel.TAG,entry);
                startActivityForResult(intent, NEW_ENTRY_REQUEST_CODE);



            }
        });

        movieList = new ArrayList<>();
        addFakeMovies();

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        interListView.removeAllViews();
        for(MovieModel entry :movieList ){
            interListView.addView(createEntryView(entry));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private MovieModel createMovieEntry(){
        MovieModel entry = new MovieModel(nextid++);

        return entry;

    }

    private MovieModel createMovieEntry(String text){
        MovieModel entry =  createMovieEntry();


        entry.setMovieName(text);


        return entry;

    }

    private TextView createEntryView(final MovieModel entry){
        final TextView textView = new TextView(context);

        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(entry.getMovieName() + "-" + entry.getId());
        textView.setPadding(15,15,15,15);
        textView.setTextSize(25);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieList.remove(entry);
                Intent viewMovieEntry = new Intent(context,MovieDetail.class);
                viewMovieEntry.putExtra(MovieModel.TAG,entry);

                startActivityForResult(viewMovieEntry,0);

            }
        });


        return textView;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if( resultCode == RESULT_OK){
            MovieModel entry = (MovieModel) data.getSerializableExtra(MovieModel.TAG);
            movieList.add(entry);
            createEntryView(entry);
        }

    }

    private void addFakeMovies(){

        movieList.add(createMovieEntry("Jaws."));
        movieList.add(createMovieEntry(" Matrix"));
    }
}
