package com.example.jacob.android_sprint1_challenge;

import java.io.Serializable;

public class Movie implements Serializable {

    public static final int NO_ID = -1;

    private String title;
    private Boolean watched;
    private int id;

    public Movie(int id, String title, Boolean watched) {
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

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
