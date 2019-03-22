package com.example.movielist;

public class MovieEntry {
    private int id;
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
