package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.os.ConditionVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class MainActivity extends AppCompatActivity {

    private Button addMovieButton;
    private MovieEntry entry;
    Context context;

    private EditText entryMovieName;

    String [] movieList = //GET USER IPUT



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         context = this;

        addMovieButton = (Button) findViewById(R.id.add_movie);
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity2();
            }

        });

        for (String animalLoop : movieList) {
            ((LinearLayout)findViewById(R.id.listOfMovies)).addView(genTextView(animalLoop));
        }

    }
        //makes button clicable
    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
        //generate textview
    public TextView genTextView(String movies){
        TextView view = new TextView(this);
        view.setText(movies);
        view.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        return view;


}