package com.example.movielist;

import java.io.Serializable;


//Didn't utilize in this class, since it is just the index when the object is created, so 2 objects can have matching indices
public class MovieData implements Serializable {
    private String title;
    private boolean watched;
    private int index;

    public MovieData(String title, boolean watched, int index) {
        this.title = title;
        this.watched = watched;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

}
