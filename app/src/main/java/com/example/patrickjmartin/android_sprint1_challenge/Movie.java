package com.example.patrickjmartin.android_sprint1_challenge;

import java.io.Serializable;

public class Movie implements Serializable {

    public static final int NO_ID = -1;

    private String title;
    private boolean watched;
    private int id;

    public Movie(int id, String title, boolean watched){
        this.id = id;
        this.title = title;
        this.watched = watched;
    }

    public Movie(int id){
        this.id = id;
    }

    public static int getNoId() {
        return NO_ID;
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
