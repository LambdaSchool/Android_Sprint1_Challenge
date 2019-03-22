package com.example.watchedmovielist;

import java.io.Serializable;

public class MovieListing implements Serializable {
    String name = "";
    boolean watched = false;

    public MovieListing(String name, boolean watched) {
        this.name = name;
        this.watched = watched;
    }


}
