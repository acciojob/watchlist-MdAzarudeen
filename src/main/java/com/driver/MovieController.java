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
    public ResponseEntity<Director> getDirectorByName(@PathVariable("director") String director)
    { return new ResponseEntity<>(movieService.getDirector(director), HttpStatus.OK); }

    @GetMapping("/getMoviesByDirectorName/{director}")
    public ResponseEntity<List> getMoviesByDirectorName(@PathVariable("director") String director)
    { return new ResponseEntity<>(movieService.getMoviesByDirector(director), HttpStatus.OK); }

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<String>> findAllMovies()
    { return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK); }
//
    @GetMapping("/deleteDirectorByName/{director}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable("director") String director)
    {
        return new ResponseEntity<>(movieService.deleteDirectorByName(director), HttpStatus.OK);
    }

    @GetMapping("/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }
}
