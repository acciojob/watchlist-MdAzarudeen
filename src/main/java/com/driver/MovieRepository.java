package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    public Map<String,Movie> movieMap = new HashMap<>();
    public Map<String,Director> directorMap = new HashMap<>();
    public Map<Integer, Pair> movieDirectorMap = new HashMap<>();

    public Map<String, Movie> getMovieMap() {
        return movieMap;
    }

    public void setMovieMap(Map<String, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public Map<String, Director> getDirectorMap() {
        return directorMap;
    }

    public void setDirectorMap(Map<String, Director> directorMap) {
        this.directorMap = directorMap;
    }

    public Map<Integer, Pair> getMovieDirectorMap() {
        return movieDirectorMap;
    }

    public void setMovieDirectorMap(Map<Integer, Pair> movieDirectorMap) {
        this.movieDirectorMap = movieDirectorMap;
    }

}
