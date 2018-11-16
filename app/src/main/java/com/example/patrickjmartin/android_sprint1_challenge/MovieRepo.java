package com.example.patrickjmartin.android_sprint1_challenge;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MovieRepo {


    private ArrayList<Movie> movies;

    public MovieRepo(){
        this.movies = new ArrayList<>();
    }

    public MutableLiveData<ArrayList<Movie>> getOverviewList() {
        MutableLiveData<ArrayList<Movie>> liveDataList = new MutableLiveData<>();
        liveDataList.setValue(movies);
        return liveDataList;
    }

    public ArrayList<Movie> addMovie(Movie movie){
        if(movie.getId() == Movie.NO_ID) {
            int movieIndex = movies.size();
            movie.setId((movieIndex));
        }
        movies.add(movie);
        return movies;
    }


    public ArrayList<Movie> removeMovie(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == movie.getId()) {
                movies.remove(i);
            }
        }
        return movies;
    }

}
