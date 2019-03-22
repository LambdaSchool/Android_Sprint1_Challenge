package com.example.watchedmovielist;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    private MovieListing movie;
    private EditText editTextView;
    private Switch watchedFlag;
    private Button saver;
    private Button ender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit);
        Intent i = getIntent();
        movie = (MovieListing)i.getSerializableExtra("KEY");
        editTextView = findViewById(R.id.name_edit_text);
        watchedFlag = findViewById(R.id.watched_switch);
        saver = findViewById(R.id.save_bttn);
        ender = findViewById(R.id.delete_button);

        if(movie != null) {

            

        }

        // 1. Check and see if sent movie
        // 2. if yes, populate fields
        // 3. Set save/delete functionality via onclick listeners for buttons


    }
}
