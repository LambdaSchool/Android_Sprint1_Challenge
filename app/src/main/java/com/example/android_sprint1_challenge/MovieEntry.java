package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieEntry implements Serializable {
    public static final String TAG = "entry";


    private String movieName;
    private Boolean isViewed;
    private int id;

    public MovieEntry(int id, String movieName, Boolean isViewed){
        this.id = id;
        this.movieName = movieName;
        this.isViewed = isViewed;

    }
    public MovieEntry(String movieName, Boolean isViewed){
        this.movieName = movieName;
        this.isViewed = isViewed;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Boolean getViewed() {
        return isViewed;
    }

    public void setViewed(Boolean isViewed) {
        this.isViewed = isViewed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }



}

