package com.movie.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieMapper movieMapper;

    public MovieController(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @GetMapping("/movies")
    public List<Movie> findByMovies(@RequestParam String startsWith) {
        return movieMapper.findByMovieStartingWith(startsWith);
    }

    @GetMapping("/movie")
    public Movie findById(@RequestParam int id) {
        return movieMapper.findById(id);
    }

    @GetMapping("/movies/year")
    public List<Movie> findByReleaseYearRange(@RequestParam int startYear, @RequestParam int endYear) {
        return movieMapper.findByPublication_yearRange(startYear, endYear);
    }
}



