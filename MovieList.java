package com.lambda.movie;

import java.io.Serializable;

public class MovieList implements Serializable {
    private int index;
    private String stringName;
    private boolean bWatched;
   MovieList(String name, boolean watched){
        this.stringName=name;
        bWatched=watched;
    }
    public String getName(){
       return stringName;
    }
    public int getIndex(){
       return this.index;
    }
    MovieList getMovieList(){
       return this;
    }
}
