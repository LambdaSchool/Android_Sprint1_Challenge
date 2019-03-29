package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {
    public static final String TAG = "movieEntry";

    public static final int INVALID_ID = -1;

    private String movieText;

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
