package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getMovieByName/{movie}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable ("movie") String movie)
    { return new ResponseEntity<>(movieService.getMovieByName(movie), HttpStatus.OK); }

    @GetMapping("/getDirectorByName/{director}")
    public Director getDirectorByName(@PathVariable("director") String director)
    { return movieService.getDirector(director); }

    @GetMapping("/getMoviesByDirectorName/{director}")
    public List getMoviesByDirectorName(@PathVariable("director") String director)
    { return movieService.getMoviesByDirector(director); }

    @GetMapping("/findAllMovies")
    public List<String> findAllMovies()
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
