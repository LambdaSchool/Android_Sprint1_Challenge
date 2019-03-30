package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MovieDetails extends AppCompatActivity {

    public static final int NEW_ENTRY_REQUEST = 1;
    private Switch watchedOrNo;
    private Button deleteMovie;
    private EditText movieName;
    Context context;
    private Button saveMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        context= this;
        watchedOrNo = findViewById(R.id.iWatchedThisMovie);
        watchedOrNo.setChecked(false);

        movieName = findViewById(R.id.editMovie);

        deleteMovie = findViewById(R.id.deleteButton);
        saveMovie = findViewById(R.id.saveButton);

    }

    //save user input --mode private means only this app can see it
    public void saveMovieTitle(View View){
        SharedPreferences sharedPref = getSharedPreferences
                ("Movie Names", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Movie Title", movieName.getText().toString());
    }

    //print out data
    public void displayData(View View) {
        SharedPreferences sharedPref = getSharedPreferences
                ("Movie Names", Context.MODE_PRIVATE);

        String movieName= sharedPref.getString("Movie Title", "");
        saveMovie.setText(movieName);



    }





    private MovieEntry createMovieEntry() {
        MovieEntry entry = new MovieEntry(movieName.toString());
        return entry;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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


}
