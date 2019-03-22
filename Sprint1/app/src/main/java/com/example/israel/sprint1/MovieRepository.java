package com.example.israel.sprint1;

import java.util.ArrayList;

public class MovieRepository {

    static private ArrayList<Movie> movies = new ArrayList<>();

    static public ArrayList<Movie> getMovies() {
        return movies;
    }

    static public void addMovie(Movie movie) {
        movies.add(movie);
    }

    static public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

}
