package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {

    public static final String TAG = "movieEntry";
    public static final int INVALID_ID = -1;
    private String movieText;
    private int id;

    public MovieEntry(String movieText, int id) {
        this.movieText = movieText;
        this.id = id;
    }

    public MovieEntry(int id) {
        this.id = id;
        this.movieText = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovieEntry(String movieText) {
        this.movieText = movieText;
    }

    public String getMovieText() {
        return movieText;
    }

    public void setMovieText(String movieText) {
        this.movieText = movieText;
    }
}
