package com.rybarstudios.movielist;

import java.util.ArrayList;

public class MovieRepo {

    //TODO: Create addMovie method, create deleteMovie method.
    private ArrayList<Movie> movieList;

    public MovieRepo(ArrayList<Movie> movieList) {
        this.movieList = new ArrayList<>();
    }

    public ArrayList<Movie> addMovie(Movie movie) {
        if(movie.getId() == Movie.INVALID_ID) {
            int index = movieList.size();
            movie.setId(index);
        }

        movieList.add(movie);

        return movieList;
    }

    public ArrayList<Movie> deleteMovie(Movie movie) {
        /*for(Movie ele : movieList) {
            if(movieList.get(ele).getId() == movie.getId()) {
                movieList.remove(ele);
            }
        }*/
        for(int i = 0; i < movieList.size(); i++) {
            if(movieList.get(i).getId() == movie.getId()) {
                movieList.remove(i);
            }
        }
        return movieList;
    }
}
