package com.example.movielist;

import java.io.Serializable;

public class MovieModel implements Serializable {

    static final String TAG = "entry";
    public static final int INVALD_ID = -1;

    private int id;
    private String movieName;

    public MovieModel(int id, String movieName) {
        this.id = id;
        this.movieName = movieName;
    }

    public MovieModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
