package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {
    public static final String MOVIE_TAG = "tagThis";

    private String movieName;
    private int movieId;
    private boolean isWatched;


    public MovieEntry(String movieName, int movieId, boolean isWatched) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.isWatched = isWatched;
    }


    public String getMovieName() {
        return movieName;
    }

    public int getMovieId() {
        return movieId;
    }



    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public MovieEntry() {

    }

}