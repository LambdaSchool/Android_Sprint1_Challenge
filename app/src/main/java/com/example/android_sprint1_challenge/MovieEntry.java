package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {

    private String movieName;

    public MovieEntry(String movieName) {
        this.movieName = movieName;
    }

    public MovieEntry(int id){
        this.movieName = "";
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}


