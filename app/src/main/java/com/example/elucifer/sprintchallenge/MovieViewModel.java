package com.example.elucifer.sprintchallenge;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<ArrayList<MovieList>> movieList;
    private MovieRepo repo;

    //gets movielist to view
    public LiveData<ArrayList<MovieList>> getMovieList(){
        if ((movieList == null)){

        }
        return movieList;
    }
    private void loadList(){
        repo = new MovieRepo();
        movieList =repo.getMovieList();
    }

    public void editMovie (MovieList movies){
        if (movieList != null){
            movieList.setValue(repo.editMovie(movies));
        }

    }


}
