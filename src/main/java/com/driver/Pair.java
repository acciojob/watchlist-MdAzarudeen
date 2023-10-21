package com.driver;

public class Pair {
    public String movie;
    public String director;

    public Pair(String movie, String director) {
        this.movie = movie;
        this.director = director;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
