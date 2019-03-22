package com.example.movielist;

import java.util.ArrayList;

public class MovieEntryRepo {
    public static ArrayList<MovieEntry> movieList = new ArrayList<>();


    public MovieEntry getMovieEntry(int id){
        return movieList.get(id);
    }

    public void addToMovieList(MovieEntry entry){
        movieList.add(entry);
    }

}
