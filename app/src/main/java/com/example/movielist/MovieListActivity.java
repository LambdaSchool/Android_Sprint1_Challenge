package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieListActivity extends AppCompatActivity {

    public static final int NEW_ENTRY_REQUEST = 2;
    public int DELETE_INDEX = 0;
    Button buttonAdd;
    LinearLayout ll;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context   = this;
        buttonAdd = findViewById(R.id.add_button);
        ll        = findViewById(R.id.ll_scrollview);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddMovieActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == NEW_ENTRY_REQUEST){
            if(data != null){
                MovieEntry entry = (MovieEntry) data.getSerializableExtra(MovieEntry.TAG);
                MovieEntryRepo.addToMovieList(entry);
                MovieEntryRepo.removeFromList(DELETE_INDEX);
            }
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        for(MovieEntry entry : MovieEntryRepo.movieList){
            ll.addView(createTextView(entry));
        }
    }

    public TextView createTextView(final MovieEntry entry){
        final TextView tv = new TextView(context);
        tv.setText(entry.getTitle());
        tv.setPadding(15,7,15,7);
        tv.setTextSize(24);
        tv.setId(entry.getId());
        if(entry.isWatched()){
            tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AddMovieActivity.class);
                intent.putExtra(MovieEntry.TAG, entry);
                ll.removeView(tv);
                DELETE_INDEX = entry.getId();
                startActivity(intent);
            }
        });
        return tv;
    }
}
