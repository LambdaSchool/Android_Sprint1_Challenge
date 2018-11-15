package com.example.patrickjmartin.android_sprint1_challenge;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    private MovieRepo repo;
    private MutableLiveData<ArrayList<Movie>> movieList;

    public LiveData<ArrayList<Movie>> getOverViewList(){
        if(movieList == null) {
            loadList();
        }

        return movieList;
    }

    private void loadList() {

        repo = new MovieRepo();
        movieList = repo.getOverviewList();

    }

    public void addMovie(Movie movie) {
        if(movieList != null){
            movieList.setValue(repo.addMovie(movie));
        }
    }

    public void removeMovie(Movie movie){
        if (movieList != null){
            movieList.setValue(repo.removeMovie(movie));
        }
    }

}
