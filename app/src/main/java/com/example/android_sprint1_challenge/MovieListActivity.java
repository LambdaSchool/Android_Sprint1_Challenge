package com.example.android_sprint1_challenge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MovieListActivity extends AppCompatActivity {


    String[] movieList = {""};

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (String movieLoop : movieList) {
            findViewById(R.id.listViewMovies);
        }


    }

    //generate text view
    public TextView genTextView(String animals){
        TextView view = new TextView(this);
        view.setText(animals);
        view.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        return view;


    }
}

