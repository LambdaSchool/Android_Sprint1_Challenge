package com.example.android_sprint1_challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieRepo {
    public static List<MovieEntry> allMovies = new ArrayList<>();

    public List<MovieEntry> getAllMovies(){
        return allMovies;
    }

}
