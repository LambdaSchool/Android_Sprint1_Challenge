package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android_sprint1_challenge.MovieEntry.*;

class MainActivity extends AppCompatActivity {



    private Button addMovieButton;
    private EditText entry;
    Context context;
    SharedPreferences savedMovie;

    private Button saveMovie;
    private ArrayList<String> addArray = new ArrayList<String>();
    private TextView showMovieList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;

        //handler for button to goto page 2
        addMovieButton = (Button) findViewById(R.id.add_movie);
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity2();
            }

        });


        //create entry
        Intent intent = getIntent();
        entry = (EditText) intent.getSerializableExtra(MovieEntry.TAG);
        if(entry == null) {
            entry = new MovieEntry(MovieEntry.INVALID_ID);
        }

        //set listerner to add movie to list via edit text and save button

        saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entry = (EditText) findViewById(R.id.add_edit_movie);
                showMovieList  = (TextView) findViewById(R.id.listViewMovies);
                showMovieList.setText(entry.getText().toString());
            }
        });

    }




    //makes addmovie button clickable
    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }




}

/*saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getMovieName = saveMovie.getText().toString();
                if (addArray).contains(getMovieName))(
                        Toast.makeText(getBaseContext(), "", Toast.LENGTH_LONG);
                        )
                else if (getMovieName == null || getMovieName.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "", Toast.LENGTH_LONG);
                }
                else {
                    addArray.add(getMovieName);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, addArray );
                    showMovieList.setAdapter(adapter);
                    ((EditText)findViewById(R.id.add_edit_movie)).setText(" ");
                }
            }
        });*/