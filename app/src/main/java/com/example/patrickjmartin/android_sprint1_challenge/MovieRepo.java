package com.example.patrickjmartin.android_sprint1_challenge;

import android.arch.lifecycle.MutableLiveData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieRepo {

    private ArrayList movies;

    public MovieRepo(){
        this.movies = new ArrayList<>();
    }

    public MutableLiveData<ArrayList<Movie>> getMovies(){
        MutableLiveData<ArrayList<Movie>> liveDataList = new MutableLiveData<>();
        liveDataList.setValue(movies);
        return liveDataList;
    }

    public ArrayList<Movie> addMovie(Movie movie) {
        if(movie.getId() == Movie.NO_ID){

        }
    }
}
