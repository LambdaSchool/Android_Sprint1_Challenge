package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.jar.JarEntry;

public class MovieDetails extends AppCompatActivity {

    public static final int NEW_ENTRY_REQUEST = 1;
    private Switch aSwitch;
    private Button deleteMovie;
    private EditText movieName;
    public static ArrayList<String> movieNameString = new ArrayList<String>();
    Context context;
    private Button saveMovie;
    private MovieEntry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);







        //saveMovie.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        movieNameString = movieName.getText().toString();
        //
        //    }
        //});



        ///retrieve

        ///SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        ///
        ///String savedMovie = preferences.getString("st","");
        ///movieName.setText(savedMovie);
        ///
        ///saveMovie.setOnClickListener(new View.OnClickListener() {
        ///    @Override
        ///    public void onClick(View v) {
        ///        movieNameString = movieName.getText().toString();
// saves/// data
        ///        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MovieDetails.this);
        ///        SharedPreferences.Editor editor = preferences.edit();
        ///
        ///        editor.putString("st",movieNameString);
        ///        editor.apply();
        ///
        ///    }
        ///});




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