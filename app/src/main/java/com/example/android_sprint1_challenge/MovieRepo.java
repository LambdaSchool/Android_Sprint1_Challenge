package com.example.android_sprint1_challenge;

import java.util.ArrayList;

public class MovieRepo {
    public ArrayList<MovieObject> allMovies = new ArrayList<>();
    private MovieObject addedMovie = new MovieObject();


    public  void addMovie(String movieName, int indexValue, Boolean isViewed){

        addedMovie.setMovieName(movieName);
        addedMovie.setViewed(isViewed);
        addedMovie.setIndexValue(indexValue);
        allMovies.add(addedMovie);



    }
    public void addMovie(MovieObject addedMovie){
        allMovies.add(addedMovie);
    }
    public ArrayList<MovieObject> getAllMovies(){
        return allMovies;
    }






}
