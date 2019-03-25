package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {

    private String movieName;

    private int movieNameInt;

    public MovieEntry(String movieName,int movieNameInt) {
        this.movieName = movieName;
        this.movieNameInt = movieNameInt;
    }

    public int getId() {
        return movieNameInt;
    }

    public void setId(int id) {
        this.movieNameInt = Integer.parseInt(movieName);
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}


