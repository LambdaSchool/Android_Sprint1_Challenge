package com.example.android_sprint1_challenge;

import java.util.ArrayList;

public class movieListApi
{
    private static ArrayList<movieModel> movieList;

    public static ArrayList<movieModel> getMovieList(){
        return movieList;
    }

    public static void deleteMovie(String movie)
    {
        for (movieModel m: movieList)
        {
            if (m.getTitle().toLowerCase().equals(movie.toLowerCase())){
                movieList.remove(m);
            }
        }
    }


   public static void addMovie(movieModel movie)
   {
       if (movieList == null) {
           movieList = new ArrayList<>();
       }

       movieList.add(movie);
   }


}


