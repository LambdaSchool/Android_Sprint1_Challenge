package com.lambda.movie;

import java.io.Serializable;

public class MovieList implements Serializable {
    private int index;
    private String stringName;
    private boolean bWatched;
   MovieList(int index, String name, boolean watched){
       this.index=index;
       this.stringName=name;
        bWatched=watched;
    }
    public String getName(){
       return stringName;
    }

    public void setIndex(int index){
        this.index=index;
    }

    public int getIndex(){
       return this.index;
    }
    public void setName(String name){
       this.stringName=name;

    }
    public void setWatched(boolean watched){
        this.bWatched=watched;
    }
    public boolean getWatched(){
       return bWatched;
    }

    public void fromString(String str, boolean watched){
         for(int i=0;i<str.length();++i){
            if(str.charAt(i)==' ') {
                str=(String)str.substring(i+1);
                stringName=str;

            }
        }
        bWatched=watched;

    }
    MovieList getMovieList(){
       return this;
    }
    public String toString(){
        return "["+index+"] "+stringName+'\n';

    }
    boolean isWatched(){
       return bWatched;
    }
    public void update(MovieList ml){
        this.index=ml.getIndex();
        this.stringName=ml.getName();
        bWatched=ml.getWatched();
    }
}

