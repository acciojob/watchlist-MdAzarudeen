package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository = new MovieRepository();
    public String addMovie(Movie movie)
    {
        Map<String,Movie> movieMap = movieRepository.getMovieMap();
        movieMap.put(movie.getName(),movie);
        return "Movie has been added successfully";
    }
    public String addDirector(Director director)
    {
        Map<String,Director> directorMap = movieRepository.getDirectorMap();
        directorMap.put(director.getName(),director);
        return "Director has been added successfully";
    }
    int k=1;
    public String addMovieDirectorPair(String movie, String director)
    {
        Map<Integer,Pair> movieDirectorMap = movieRepository.getMovieDirectorMap();
        Map<String,Director> directorMap = movieRepository.getDirectorMap();
        Map<String,Movie> movieMap = movieRepository.getMovieMap();
        if(directorMap.containsKey(director) && movieMap.containsKey(movie))
                {
                    Pair pair = new Pair(movie,director);
                    movieDirectorMap.put(k,pair);
                    k++;
                    return movie+" directed by "+director+" has been added";
                }
        return "Movie or Director is not in the database";
    }

    public Movie getMovie(String movie)
    {
        return movieRepository.getMovieByName(movie);
    }

    public Director getDirector(String director)
    {
        return movieRepository.directorMap.get(director);
    }
    public List getMoviesByDirector(String director) {
       List<String > moviesList = new ArrayList<>();
        Map<Integer,Pair> movieDirectorMap = movieRepository.getMovieDirectorMap();
        for (Pair pair: movieDirectorMap.values())
        {
            if(pair.getDirector().equals(director))
                moviesList.add(pair.getMovie());
        }

        return moviesList;
    }
//
    public List getMovies()
    {
        List<String> moviesList = new ArrayList<>();
        Map<String,Movie> movieMap = movieRepository.getMovieMap();
        for(Movie movie: movieMap.values())
            moviesList.add(movie.getName());

        return moviesList;
    }

    public String deleteDirectorByName(String director)
    {
        Map<Integer,Pair> movieDirectorMap = movieRepository.getMovieDirectorMap();
        Map<String,Director> directorMap = movieRepository.getDirectorMap();
        Map<String,Movie> movieMap = movieRepository.getMovieMap();
        if(directorMap.containsKey(director))
        {
            for (int key : movieDirectorMap.keySet()) {
                Pair pair = movieDirectorMap.get(key);
                if (pair.getDirector().equals(director)) {
                    movieDirectorMap.remove(key);
                    directorMap.remove(director);
                    movieMap.remove(pair.getMovie());
                }
            }
            return "Director " + director + " and his movies are deleted from database";
        }
        else
            return "No such director exists";
    }

    public String deleteAllDirectors()
    {
        Map<Integer,Pair> movieDirectorMap = movieRepository.getMovieDirectorMap();
        Map<String,Director> directorMap = movieRepository.getDirectorMap();
        Map<String,Movie> movieMap = movieRepository.getMovieMap();
            for (int key : movieDirectorMap.keySet())
            {
                Pair pair = movieDirectorMap.get(key);
                    movieDirectorMap.remove(key);
                    directorMap.remove(pair.getDirector());
                    movieMap.remove(pair.getMovie());
            }
            return "All Director and their movies are deleted from database";
        }
}
