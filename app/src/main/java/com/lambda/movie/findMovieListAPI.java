package com.lambda.movie;

import java.util.ArrayList;

public class findMovieListAPI {
    private ArrayList<MovieList> amlToFind;
    MovieList ml=null;
    findMovieListAPI(ArrayList<MovieList> aml){
        amlToFind=aml;
    }
    MovieList findMovieListByIndex(int index){

        for(int i=0;i<amlToFind.size();i++){
            ml=amlToFind.get(i);
            if(ml.getIndex()==index){
                ml = amlToFind.get(i);
                return ml;
            }
        }
        return null;
    }
    MovieList findMovieListByName(String name){
        for(int i=0;i<amlToFind.size();i++){
            ml=amlToFind.get(i);
            if(ml.getName().equals(name)){
                ml = amlToFind.get(i);
            }
        }
        return ml;
    }

    ArrayList<MovieList> deleteMovieList(MovieList ml){
        if(ml.getIndex()==-1) return amlToFind;
        for(int i=0;i<amlToFind.size();i++){
            if(ml.getIndex()==amlToFind.get(i).getIndex()){

                amlToFind.remove(i);
                return amlToFind;

            }
        }
        return amlToFind;
    }


    ArrayList<MovieList> updateMovieList(MovieList ml){
        int index=amlToFind.size();
        if(ml.getIndex()==-1){  //new index assignment
            amlToFind.add(ml);
            int newIndex=index;
            int i;
            for(i=0;i<index-1;i++){
                    if(amlToFind.get(i).getIndex()==newIndex){
                        newIndex++;
                        i=0; //go back to begining to check again
                    }
            }
            amlToFind.get(i).setIndex(newIndex);
        }
        for(int i=0;i<amlToFind.size();i++){
            if(ml.getIndex()==amlToFind.get(i).getIndex()){

                amlToFind.get(i).update(ml);
                return amlToFind;
            }
        }
        return amlToFind;
    }
}
