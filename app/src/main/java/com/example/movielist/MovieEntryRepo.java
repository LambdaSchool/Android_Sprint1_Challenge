package com.example.movielist;

import java.util.ArrayList;

public class MovieEntryRepo {
    private static int INDEX = 1;
    public static ArrayList<MovieEntry> movieList = new ArrayList<>();

    MovieEntryRepo(){
        MovieEntry entry = new MovieEntry();
        entry.setWatched(true);
        entry.setTitle("Test");
        entry.setId(0);
        movieList.add(entry);
    }


    public static MovieEntry getMovieEntry(int id){
        return movieList.get(id);
    }

    public static void addToMovieList(MovieEntry entry){
        movieList.add(entry);
        INDEX++;
    }

    public static int getIndex(){
        return INDEX;
    }

}
