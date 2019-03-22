package com.example.elucifer.sprintchallenge;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MovieRepo {
    //declaring the movielist in the model
    private  ArrayList<MovieList> movieList;

    public MovieRepo() {this.movieList=new ArrayList<>();}
   public  MutableLiveData<ArrayList<MovieList>>getMovieList(){
       final MutableLiveData<ArrayList<MovieList>>liveDataList = new MutableLiveData<>();
         liveDataList.setValue(movieList);
       return liveDataList;
   }
   public ArrayList<MovieList> editMovie(MovieList movies){
            movieList.add(movies);
            return movieList;




   }


}

