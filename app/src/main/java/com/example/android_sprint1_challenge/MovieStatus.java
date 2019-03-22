package com.example.android_sprint1_challenge;

import java.io.Serializable;

public class MovieStatus implements Serializable {
        public String movieName;
        public boolean viewed;

        public MovieStatus(String movieName, Boolean viewed){
            this.movieName = movieName;
            this.viewed = viewed;

        }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }


    public MovieStatus MovieFile() {
        MovieStatus moviefile = new MovieStatus("", false);

        return moviefile;
    }
}
