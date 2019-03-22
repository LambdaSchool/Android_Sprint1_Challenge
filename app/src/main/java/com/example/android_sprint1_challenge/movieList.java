package com.example.android_sprint1_challenge;

import android.content.Intent;

import java.util.ArrayList;

public class movieList
{

    ArrayList<movieModel> movies;

    public movieList(ArrayList<movieModel> movies) {
        this.movies = movies;
    }

    public ArrayList<movieModel> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<movieModel> movies) {
        this.movies = movies;
    }
}