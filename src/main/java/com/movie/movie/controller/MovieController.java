package com.movie.movie.controller;

import com.movie.movie.entity.Movie;
import com.movie.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Movie> getMovies(@RequestParam(required = false) Integer id,
                                 @RequestParam(required = false) String titleStartsWith,
                                 @RequestParam(required = false) Integer fromYear,
                                 @RequestParam(required = false) Integer toYear) {
        if (id != null) {
            return List.of(movieService.findMovieById(id));
        } else if (titleStartsWith != null) {
            return movieService.findMoviesByTitleStartsWith(titleStartsWith);
        } else if (fromYear != null && toYear != null) {
            return movieService.findMoviesByYearRange(fromYear, toYear);
        } else {
            return movieService.findAll();
        }
    }
}

