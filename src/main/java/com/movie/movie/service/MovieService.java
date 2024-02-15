package com.movie.movie.service;

import com.movie.movie.exception.InvalidYearException;
import com.movie.movie.exception.MovieNotFoundException;
import com.movie.movie.entity.Movie;
import com.movie.movie.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Movie> findMovieStartsWith(String startsWith) throws MovieNotFoundException {
        List<Movie> movies = this.movieMapper.findByMovieStartsWith(startsWith);
        if (!movies.isEmpty()) {
            return movies;
        } else {
            throw new MovieNotFoundException("Movie not found");
        }
    }

    public List<Movie> findMovieYear(Integer startYear, Integer endYear) throws InvalidYearException {
        List<Movie> movies = this.movieMapper.findByYear(startYear, endYear);
        if (endYear != null && startYear !=null && endYear > startYear) {
            return movies;
        } else {
            throw new InvalidYearException("movie not found");
        }
    }
}
