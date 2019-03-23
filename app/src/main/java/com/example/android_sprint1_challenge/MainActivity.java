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
                startActivity(intent);

            }

        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {

                Log.i("check", "onActivityResult: activity");

                ArrayList<movieModel> movies = new ArrayList<>();
                //Intent finalIntent = getIntent();
                //movieModel movie = (movieModel) getIntent().getSerializableExtra("movie");
                movieModel movie = new movieModel(1,intent.getStringExtra("movie"), intent.getBooleanExtra("watched",false));
                movies.add(movie);
                //for (movieModel movie : movies) {

                scrollLayout.addView(createTextView(movie.getTitle(), movie.isSeen()));



                }
            }
        }






    public TextView createTextView(final String title, final boolean seenIt)
    {


        final TextView tv = new TextView(getApplicationContext());
        tv.setText(title);
        //tv.setTextSize(24);
        if(seenIt)
        {
            tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    return tv;
    }
}
