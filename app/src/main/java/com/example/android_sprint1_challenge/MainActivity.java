package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE1 = 11;
    final int REQUEST_CODE = 19;

    Button addButton;
    Context context;
    LinearLayout scrollLayout;

    //final ArrayList<movieModel> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollLayout = findViewById(R.id.scroll_layout);
        addButton = findViewById(R.id.add_button);
        context = this;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent  intent = new Intent(context, editList.class);
                startActivityForResult(intent, REQUEST_CODE1);

            }

        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i( getLocalClassName(),this.getClass().getSimpleName() + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i( getLocalClassName(),this.getClass().getSimpleName() + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i( getLocalClassName(),this.getClass().getSimpleName() + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i( getLocalClassName(),this.getClass().getSimpleName() + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i( getLocalClassName(),this.getClass().getSimpleName() + "onDestroy");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE1){
            if (resultCode == RESULT_OK){

                Log.i( getLocalClassName(),this.getClass().getSimpleName() + "onActivityResult");
                scrollLayout.removeAllViews();


                ArrayList<movieModel> movies ;
                movies = movieRepo.getMovieList();

                for (movieModel movie:movies)
                {
                    scrollLayout.addView(createTextView(movie));

                }

            }

        }




    }

    public TextView createTextView(final  movieModel movie)
    {


        final TextView tv = new TextView(getApplicationContext());
        tv.setText(movie.getTitle());
        tv.setTextSize(24);
        if(movie.isSeen())
        {
            tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, editList.class);
                intent.putExtra(movieModel.TAG, movie);
                startActivityForResult(intent, REQUEST_CODE1);

            }
        });
    return tv;
    }
}
