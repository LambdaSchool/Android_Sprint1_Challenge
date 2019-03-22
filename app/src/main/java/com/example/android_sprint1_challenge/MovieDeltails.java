package com.example.android_sprint1_challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;

public class MovieDeltails extends AppCompatActivity {
EditText editText;
Switch viewed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_deltails);
        editText = findViewById(R.id.movie_edit_text);
        viewed = findViewById(R.id.switch1);
        







    }
}
