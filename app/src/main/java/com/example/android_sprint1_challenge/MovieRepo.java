package com.example.android_sprint1_challenge;

import android.graphics.Movie;

import java.util.ArrayList;

public class MovieRepo {
    public ArrayList<MovieStatus> allMovies = new ArrayList<>();
    private MovieStatus addedMovie = new MovieStatus();


    public  void addMovie(String movieName, int indexValue, Boolean isViewed){

        addedMovie.setMovieName(movieName);
        addedMovie.setViewed(isViewed);
        addedMovie.setIndexValue(indexValue);
        allMovies.add(addedMovie);



    }
    public void addMovie(MovieStatus addedMovie){
        allMovies.add(addedMovie);
    }
    public ArrayList<MovieStatus> getAllMovies(){
        return allMovies;
    }






}
