package com.lambdaschool.android_sprint1_challenge;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    public static ArrayList<Movie> movieList = new ArrayList<>();
    private String movieTitle;
    private boolean watched;

    public Movie(String movieTitle, boolean watched) {
        this.movieTitle = movieTitle;
        this.watched = watched;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
