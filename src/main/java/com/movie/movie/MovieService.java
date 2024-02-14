package com.movie.movie;

import com.movie.movie.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {

        this.movieMapper = movieMapper;
    }

    public Iterable<Movie> findAll() {
        return this.movieMapper.findAll();
    }

    public Movie findMovie(Integer id) throws MovieNotFoundException {
        Optional<Movie> movie = this.movieMapper.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new MovieNotFoundException("movie not found");
        }
    }
}
