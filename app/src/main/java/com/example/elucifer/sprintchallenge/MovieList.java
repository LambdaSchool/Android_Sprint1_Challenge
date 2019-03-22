package com.example.elucifer.sprintchallenge;

import java.io.Serializable;

public class MovieList implements Serializable {

    private String movieTitle;
    private int id;

    public MovieList(int id,String movieTitle){
        this.id = id;
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
