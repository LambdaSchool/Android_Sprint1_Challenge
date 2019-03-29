package com.example.android_sprint1_challenge;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class ButtonsPage extends AppCompatActivity {

    private Switch watchedOrNo;
    private Button saveMovie;
    private Button deleteMovie;
    private EditText movieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_page);

        watchedOrNo = findViewById(R.id.iWatchedThisMovie);
        watchedOrNo.setChecked(false);

        movieName = findViewById(R.id.editMovie);
        saveMovie = findViewById(R.id.saveButton);
        deleteMovie = findViewById(R.id.deleteButton);
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
