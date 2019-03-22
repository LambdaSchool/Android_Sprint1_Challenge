package com.jakeesveld.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.util.List;

public class EditActivity extends AppCompatActivity {

    Button buttonDelete;
    Button buttonAdd;
    EditText textEditTitle;
    Switch switchWatched;
    Boolean isWatched;
    Context context;
    public final int MOVIE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final Intent intent = getIntent();
        final Movies newMovie = (Movies) intent.getSerializableExtra("movie");

        buttonAdd = findViewById(R.id.button_add);
        buttonDelete = findViewById(R.id.button_delete);
        textEditTitle = findViewById(R.id.text_edit_title);
        switchWatched = findViewById(R.id.switch_watched);
        context = this;
        isWatched = false;


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String movieTitle = textEditTitle.getText().toString();
                Boolean movieWatched = isWatched;
                newMovie.setTitle(movieTitle);
                newMovie.setWatched(movieWatched);
                intent.putExtra("movie", newMovie);
                intent.putExtra("add", true);
                setResult(MOVIE_REQUEST_CODE, intent);
                finish();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Movies movie = new Movies(textEditTitle.getText().toString(), isWatched);
//                MoviesRepository.deleteMovieFromList(movie);
//                Intent intent = new Intent(context, ListActivity.class);
//                startActivity(intent);
            }
        });
    }

/*    private Movies addMovieToList (String title, Boolean watched){
        Movies movie = new Movies(title, watched);
        MoviesRepository.addMovieToList(movie);

        return movie;
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        switchWatched.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    isWatched = true;
                }else{
                    isWatched =false;
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
