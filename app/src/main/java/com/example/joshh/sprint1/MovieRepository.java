package com.example.joshh.sprint1;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MovieRepository {

    private ArrayList<Movie> movies;

    public MovieRepository() {
        this.movies = new ArrayList<>();
    }

    public MutableLiveData<ArrayList<Movie>> getMovies() {
        MutableLiveData<ArrayList<Movie>> liveDataList = new MutableLiveData<>();
        liveDataList.setValue(movies);
        return liveDataList;
    }

    public ArrayList<Movie> addMovie(Movie movie) {
        if(movie.getId() == Movie.NO_ID){
            int movieIndex = movies.size();
            movie.setId(movieIndex);
        }
        movies.add(movie);
        return movies;
    }

    public ArrayList<Movie> removeMovie(Movie movie){
        for(int i = movies.size() - 1; i >= 0; i--){
            if(movies.get(i).getId() == movie.getId()){
                movies.remove(i);
            }
        }
        return movies;
    }
}
