package com.example.joshh.sprint1;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {
    private MovieRepository repo;
    private MutableLiveData<ArrayList<Movie>> movieList;

    public LiveData<ArrayList<Movie>> getMovieList(){
        if(movieList == null){
            loadList();
        }
        return movieList;
    }

    private void loadList(){
        repo = new MovieRepository();
        movieList = repo.getMovies();
    }

    public void addMovie(Movie movie){
        if(movieList != null){
            movieList.setValue(repo.addMovie(movie));
        }
    }

    public void removeMovie(Movie movie){
        if(movieList != null){
            movieList.setValue(repo.removeMovie(movie));
        }
    }

}
