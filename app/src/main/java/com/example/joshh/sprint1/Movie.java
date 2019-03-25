package com.example.joshh.sprint1;

import java.io.Serializable;

public class Movie implements Serializable {

    public static final int NO_ID = -1;

    private String title;
    private boolean isWatched;
    private int id;

    public Movie(int id, String title, boolean isWatched){
        this.id = id;
        this.title = title;
        this.isWatched = isWatched;
    }
    public Movie(int id){
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public void setId(int id) {
        this.id = id;
    }
}
