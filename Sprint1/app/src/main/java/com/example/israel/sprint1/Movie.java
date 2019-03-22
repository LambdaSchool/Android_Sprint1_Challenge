package com.example.israel.sprint1;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private boolean isWatched;

    public Movie(String name, boolean isWatched) {
        this.name = name;
        this.isWatched = isWatched;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean isWatched) {
        this.isWatched = isWatched;
    }
}
