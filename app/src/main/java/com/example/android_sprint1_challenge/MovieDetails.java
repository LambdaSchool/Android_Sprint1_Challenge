package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MovieDetails extends AppCompatActivity {

    private EditText editName;
    private Button saveMovie;
    private SharedPreferences savedMovieTitle;
    private Switch watchedOrNo;
    private Button deleteMovie;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        context= this;
        watchedOrNo = findViewById(R.id.iWatchedThisMovie);
        //watchedOrNo.setChecked(false);

        editName = findViewById(R.id.editMovie);
        saveMovie = findViewById(R.id.saveButton);
        savedMovieTitle = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        deleteMovie = findViewById(R.id.deleteButton);

        editName.setText(savedMovieTitle.getString("tag",""));
        saveMovie.setOnClickListener(saveButton);
    }

    private void makeTag(String tag){
        String or = savedMovieTitle.getString(tag,"");
        SharedPreferences.Editor preferencesEditor = savedMovieTitle.edit();
        preferencesEditor.putString("tag", tag);
        preferencesEditor.commit();
    }

    public View.OnClickListener saveButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editName.getText().length()>0){
                makeTag(editName.getText().toString());

                ((InputMethodManager) getSystemService
                        (Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow
                        (editName.getWindowToken(),0);
            }
        }
    };




    ////save user input --mode private means only this app can see it
    //public void saveMovieTitle(View View){
    //    SharedPreferences sharedPref = getSharedPreferences
    //            ("Movie Names", Context.MODE_PRIVATE);
    //
    //    SharedPreferences.Editor editor = sharedPref.edit();
    //    editor.putString("Movie Title", editName.getText().toString());
    //}
    //
    ////print out data
    //public void displayData(View View) {
    //    SharedPreferences sharedPref = getSharedPreferences
    //            ("Movie Names", Context.MODE_PRIVATE);
    //
    //    String editName= sharedPref.getString("Movie Title", "");
    //    saveMovie.setText(editName);
    //
    //}







    private MovieEntry createMovieEntry() {
        MovieEntry entry = new MovieEntry(editName.toString());
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
