package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService = new MovieService();

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @PostMapping("/addDirector")
    public String addDirector(@RequestBody Director director)
    {
        return movieService.addDirector(director);
    }

    @PutMapping("/addMovieDirectorPair/{movie}/{director}")
    public String addMovieDirectorPair(@PathVariable ("movie")String movie, @PathVariable("director") String director)
    { return  movieService.addMovieDirectorPair(movie,director);  }

    @GetMapping("/getMovie/{movie}")
    public Movie getMovie(@PathVariable ("movie") String movie)
    { return movieService.getMovie(movie); }

    @GetMapping("/getDirector/{director}")
    public Director getDirector(@PathVariable("director") String director)
    { return movieService.getDirector(director); }

    @GetMapping("/getMoviesByDirectorName/{director}")
    public List getMovies(@PathVariable("director") String director)
    { return movieService.getMoviesByDirector(director); }

    @GetMapping("/findAllMovies")
    public List getMovieNames()
    { return movieService.getMovies(); }
//
    @GetMapping("/deleteDirectorByName/{director}")
    public String deleteDirectorByName(@PathVariable("director") String director)
    {
        return movieService.deleteDirectorByName(director);
    }

    @GetMapping("/deleteAllDirectors")
    public String deleteAllDirectors()
    {
        return movieService.deleteAllDirectors();
    }
}
