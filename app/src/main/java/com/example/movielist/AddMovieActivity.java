package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddMovieActivity extends AppCompatActivity {

    EditText titleField;
    Switch watchedSwitch;
    Button confirmButton;
    Button removeButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        titleField    = findViewById(R.id.title_field);
        watchedSwitch = findViewById(R.id.watch_switch);
        confirmButton = findViewById(R.id.button_confirm);
        removeButton  = findViewById(R.id.button_remove);

        context = this;

        Intent intent = this.getIntent();
        if(intent.getExtras() != null){
            editMovieEntry(MovieEntryRepo.getMovieEntry(intent.getIntExtra("keyMovieClick",0)));
        }



        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieEntry movieEntry = new MovieEntry();
                movieEntry.setId(MovieEntryRepo.getIndex());
                movieEntry.setTitle(titleField.getText().toString());
               // movieEntry.setWatched(watchedSwitch.isChecked());

                MovieEntryRepo.addToMovieList(movieEntry);

                Intent intent = new Intent(context, MovieListActivity.class);
                intent.putExtra("FirstKey", "add");
                intent.putExtra("key", movieEntry.getId());
                startActivity(intent);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void editMovieEntry(MovieEntry entry){
        titleField.setText(entry.getTitle());
        watchedSwitch.setChecked(entry.isWatched());

      //  addEntry(entry);
    }

    public void addEntry(){

    }

    public void addEntry(MovieEntry entry){

    }

    public void removeEntry(){

    }
}
