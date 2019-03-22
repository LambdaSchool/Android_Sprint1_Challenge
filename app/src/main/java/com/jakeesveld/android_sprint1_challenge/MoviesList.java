package com.jakeesveld.android_sprint1_challenge;

import java.util.ArrayList;

public class MoviesList {

    private String title;
    private Boolean isWatched;

    public MoviesList(String title, Boolean isWatched) {
        this.title = title;
        this.isWatched = isWatched;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getWatched() {
        return isWatched;
    }

    public void setWatched(Boolean watched) {
        isWatched = watched;
    }
}
