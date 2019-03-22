package com.example.movielist;

import java.io.Serializable;

public class MovieEntry implements Serializable {
    private int id;
    public static final String TAG = "MovieEntry";
    private String title;
    private boolean isWatched;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
