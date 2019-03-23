package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class AddNewMovie extends AppCompatActivity implements Serializable {
    private EditText movieInput;
    private Button saveButton, deleteButton;
    private Switch viewedSwitch;
    //private Boolean switchViewed;
    Context context;
    private MovieEntry entry;
    private String entryString;
    private ArrayList<MovieEntry> entryList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_movie);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Intent passList = getIntent();
//    entryList = (ArrayList<MovieEntry>) passList.getSerializableExtra("movieList");
        context = this;
        movieInput = findViewById(R.id.movie_edit_text);
//            Movie input is the editText that takes the information from the listener and assignes it to entryString
        movieInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                entryString = s.toString();

            }
        });



        saveButton = findViewById(R.id.button_save);
//            saveButton is the button that is going to start the process of building the MovieEntry
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newCreatedMovie = new Intent(context, MovieListActivity.class);
//                movieEntry needs id, boolean, name
                viewedSwitch = findViewById(R.id.watched_switch);
//            viewedSwitch is the switch that takes viewed as true or false and returns value to switchViewed
                final Boolean switchViewed = viewedSwitch.isChecked();


                MovieEntry entry = new MovieEntry(entryString, switchViewed);

                passList.putExtra("moviename", entry.getMovieName());
                passList.putExtra("movieboolean", entry.getViewed());
                setResult( MovieListActivity.RESULT_OK ,  passList);
                finish();

            }
        });
        deleteButton = findViewById(R.id.button_delete);







    }




}
