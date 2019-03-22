package com.rybarstudios.movielist;

import java.io.Serializable;

public class Movie implements Serializable {
    public static final int INVALID_ID = -1;
    private String title;
    private boolean watched;
    private int id;

    public Movie(String title, boolean watched, int id) {
        this.title = title;
        this.watched = watched;
        this.id = id;
    }

    public Movie(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
