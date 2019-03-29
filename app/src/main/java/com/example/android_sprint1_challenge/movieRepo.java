package com.example.android_sprint1_challenge;

import android.content.Intent;

import java.util.ArrayList;

public class movieRepo
{
    //This is the "repo"

   public static ArrayList<movieModel> getMovieList()
   {
       return movieListApi.getMovieList();
   }


}