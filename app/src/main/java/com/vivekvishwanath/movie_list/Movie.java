package com.vivekvishwanath.movie_list;

public class Movie {

    private String movieTitle;
    private int movieId;
    private boolean isWatched;

    public Movie(String movieTitle, int movieId, boolean isWatched) {
        this.movieTitle = movieTitle;
        this.movieId = movieId;
        this.isWatched = isWatched;
    }

    public Movie() {

    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }
}
