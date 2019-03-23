package com.lambda.movie;

import java.io.Serializable;

public class MovieList implements Serializable {

    private static String stringName;
    private static boolean bWatched;
   MovieList(String name, boolean watched){
        this.stringName=name;
        bWatched=watched;
    }
    public String getName(){
       return stringName;
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
       if( bWatched==false)return stringName+'\n';
       else    return "<strike>"+stringName+"</strike>"+'\n';

    }
}

