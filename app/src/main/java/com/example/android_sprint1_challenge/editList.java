package com.example.android_sprint1_challenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.android_sprint1_challenge.MainActivity.REQUEST_CODE1;

public class editList extends AppCompatActivity
{
    //final int REQUEST_CODE = 19;

    EditText addMovie;
    AppCompatCheckBox checkWatched;
    Context context;
    Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context = this;
        buttonDelete = findViewById(R.id.button_delete);
        addMovie = findViewById(R.id.add_movie);
        checkWatched = findViewById(R.id.check_watched);
        FloatingActionButton fab = findViewById(R.id.fab);

        Intent startIntent = getIntent();
        if (startIntent.getSerializableExtra(movieModel.TAG) != null){
            movieModel m = (movieModel) startIntent.getSerializableExtra(movieModel.TAG);
            addMovie.setText(m.getTitle());
        }

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ()
                movieListApi.deleteMovie(movieListApi.getMovieList().equals(addMovie.getText().toString()));
                addMovie.setText("");

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int index = 0;
                movieModel movie;
                movie = new movieModel(index++,addMovie.getText().toString(),checkWatched.isChecked());
                movieListApi.addMovie(movie);

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
//                startActivityForResult(intent, REQUEST_CODE1);
                finish();

                /*Intent intent;
                int index = 0;
                movieModel movie;
                movie = new movieModel(index++,addMovie.getText().toString(),checkWatched.isChecked());


                //intent.putExtra("movie", movie);
                intent.putExtra("movie", addMovie.getText().toString());
                intent.putExtra("watched", checkWatched.isChecked());

                finish();*/
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


}
