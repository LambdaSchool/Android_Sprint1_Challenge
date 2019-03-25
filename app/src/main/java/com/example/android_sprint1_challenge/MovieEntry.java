package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {

    public static final String TAG = "MovieEntry";
    public static final int INVALID_ID = -1;

    private String movieName;

    private int nextId;

    public MovieEntry(String movieName, int nextId) {
        this.movieName = movieName;
        this.nextId = nextId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }
}


