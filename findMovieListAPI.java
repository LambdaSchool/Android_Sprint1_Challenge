package com.lambda.movie;

import java.util.ArrayList;

public class findMovieListAPI {
    ArrayList<MovieList> findMovieList(ArrayList<MovieList> aml, String name){
        MovieList ml;
        ArrayList<MovieList> tempAML=new ArrayList<MovieList>();
        tempAML.add(null);
        for(int i=0;i<aml.size();i++){
            ml=aml.get(i);
            if(ml.getName().equals(name)){
                tempAML.add(ml);
                ml = aml.get(i);
                tempAML.set(0,ml);

            }else{
                tempAML.add(ml);
            }


        }
        return tempAML;
    }


}
