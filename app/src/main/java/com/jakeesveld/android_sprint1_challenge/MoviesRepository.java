package com.jakeesveld.android_sprint1_challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MoviesRepository {

    private static ArrayList<Movies> moviesList;

    public static void addMovieToList (Movies movie){
        moviesList.add(movie);
    }

    public static void deleteMovieFromList (Movies movie){
        String movieName = movie.getTitle();
        for(Movies selectedMovie: moviesList){
            if(selectedMovie.getTitle().equals(movie.getTitle())){
                moviesList.remove(selectedMovie);
            }
        }
    }

    public static ArrayList<Movies> getMoviesList (){
        return moviesList;
    }
}
