package com.movie.movie.controller;

import com.movie.movie.entity.Movie;
import com.movie.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Iterable<Movie> getMovies() {
        return movieService.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable("id") Integer id) {
        return movieService.findMovie(id);
    }

    @GetMapping("/movies/title")
    public List<Movie> getMovieStartsWith(@RequestParam String startsWith) {
        return movieService.findMovieStartsWith(startsWith);
    }
//
    @GetMapping("/movies/year")
    public List<Movie> getMovieYear(@RequestParam Integer startYear, Integer endYear) {
        return movieService.findMovieYear(startYear, endYear);
    }
}
