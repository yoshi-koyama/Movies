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

    @GetMapping("/Movie")
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @GetMapping("/movie/{id}")
    public Movie findById(@PathVariable Integer id) {
        return movieMapper.findById(id);
    }

    @GetMapping("/movie")
    public List<Movie> findByTitles(@RequestParam(name = "startsWith") String startsWith) {
        return movieMapper.findByMovieStartsWith(startsWith);
    }
}





