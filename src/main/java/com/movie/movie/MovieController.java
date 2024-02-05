package com.movie.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie findById(@PathVariable Integer id) {
        return movieMapper.findById(id);
    }

    @GetMapping("/movies/title")
    public List<Movie> findByTitles(@RequestParam String startsWith) {
        return movieMapper.findByMovieStartsWith(startsWith);
    }

    @GetMapping("/movies/year")
    public List<Movie> findByYear(@RequestParam Integer startYear, @RequestParam Integer endYear) {
        return movieMapper.findByYear(startYear, endYear);
    }
}





