package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity implements Serializable {
    public static final int Null_DEFAULT = 1111;
    public static final int DELETE = 5000;
    LinearLayout listView;
    Context context;
    ArrayList<MovieEntry> entryList;

    public static final int ACTIVITY_REQUEST_CODE = 1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == ACTIVITY_REQUEST_CODE) {
            if (data != null) {
                if(MovieRepo.allMovies.size()>0){
                    if(listView != null){listView.removeAllViews();}
                    for(MovieEntry entry: MovieRepo.allMovies){
                        createEntryView(entry);

                    }
                }
//  entryList.set(id, newEntry);


            }
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        context = this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddNewMovie.class);

                startActivityForResult(intent, ACTIVITY_REQUEST_CODE);

            }
        });



    }


    private TextView createEntryView(final MovieEntry entry){

        Boolean viewedYes = entry.getViewed();
        TextView view = new TextView(context);
        listView = findViewById(R.id.list_view);
        listView.addView(view);
        view.setId(entry.getId());
        view.setText(entry.getMovieName());
        view.setTextSize(25);
        view.setTypeface(Typeface.DEFAULT_BOLD);
        view.setPadding(15,15,15,15);
        if(viewedYes){view.setTextColor(getResources().getColor(R.color.colorPrimary));}
        else{view.setTextColor(getResources().getColor(R.color.colorAccent));}
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDetailIntent = new Intent(context, AddNewMovie.class );
                viewDetailIntent.putExtra("textmovieName", entry.getMovieName());
                viewDetailIntent.putExtra("textmovieId", entry.getId());
                viewDetailIntent.putExtra("textmovieBoolean", entry.getViewed());
                MovieRepo.allMovies.remove(entry.getId());
                startActivity(viewDetailIntent);
            }
        });




        return view;
    }


}
