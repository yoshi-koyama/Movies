package com.movie.movie;

import com.movie.movie.Movie;
import com.movie.movie.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}