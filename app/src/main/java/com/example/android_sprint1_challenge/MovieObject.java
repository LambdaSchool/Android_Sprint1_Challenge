package com.example.android_sprint1_challenge;

import android.graphics.Movie;

import java.io.Serializable;

public class MovieObject implements Serializable {
    private String movieName;
    private boolean viewed;
    private int indexValue;

    public MovieObject(String movieName, int indexValue, Boolean viewed) {
        this.movieName = movieName;
        this.viewed = viewed;
        this.indexValue = indexValue;
    }

    public String getMovieName() {
        if (movieName == null) {
            movieName = "no movies to show";
        }
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public int getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(int indexValue) {
        this.indexValue = indexValue;
    }


    public MovieObject() {
        movieName = "DEFAULT";
        indexValue = 0;
        viewed = false;
    }

}