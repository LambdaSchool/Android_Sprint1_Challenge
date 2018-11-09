package com.example.elucifer.sprintchallenge;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout listLayout;
     private Context context;
     private MovieViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLayout=findViewById(R.id.list_layout);
        context=this;

        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        final Observer<ArrayList<MovieList>> observer=new Observer<ArrayList<MovieList>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MovieList> movieLists) {
            if (movieLists != null) {


            }
            }
        };

    }
}
