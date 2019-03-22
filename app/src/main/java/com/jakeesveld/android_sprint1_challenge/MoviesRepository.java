package com.jakeesveld.android_sprint1_challenge;

import java.util.ArrayList;

public class MoviesRepository {

    static ArrayList<Movies> moviesList;

    public static ArrayList<Movies>getMoviesList(){
        return moviesList;
    }

    public static void addMovieToList(Movies movie){
        moviesList.add(movie);
    }

    public static void removeMovieFromList(int id){
        moviesList.remove(id);
    }
}
