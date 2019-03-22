package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Intent fullIntent;
Button addButton;
Context context;
Boolean viewed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent saveMovie = new Intent();
        String movieName = saveMovie.getStringExtra("movieName");
        viewed = saveMovie.getBooleanExtra("viewed", false);






        addButton = findViewById(R.id.button_add_movie);
        context = this;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovie = new Intent(context, MovieDeltails.class);
                startActivity(addMovie);




            }
        });



    }












    public TextView createTextView(final String imageText, final int listIndex,  Boolean viewed){
        fullIntent = new Intent(context, MainActivity.class);
        TextView        textView        = new TextView (getApplicationContext ());
        ScrollView layoutLinear    = findViewById ( R.id.scroll_view );
        layoutLinear.addView ( textView);
        textView.setId ( listIndex );
        textView.setText ( imageText );
        textView.setTextSize(15);
        textView.setPadding ( 10,10,10,10 );
        textView.setWidth ( 200);
        textView.setHeight ( 100 );
        if(viewed = true){
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        }else {textView.setTextColor(getResources().getColor(R.color.colorAccent));}



        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                fullIntent.putExtra("index", listIndex);
                fullIntent.putExtra("name", imageText );
                startActivity(fullIntent);


            }
        });

        return textView;
    }

}
