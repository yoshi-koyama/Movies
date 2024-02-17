package com.movie.movie.service;

import static org.junit.jupiter.api.Assertions.*;

import com.movie.movie.entity.Movie;
import com.movie.movie.mapper.MovieMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieService movieService;

    @Test
    void findAllを実行するとMovieのリストが取得できること() {
        // Mocking the behavior of MovieMapper
        List<Movie> movies = List.of(new Movie(1, "Sample Movie", 1994));
        doReturn(movies).when(movieMapper).findAll();

        // Calling the method to be tested
        List<Movie> result = movieService.findAll();

        // Assertions
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(new Movie(2, "Sample Movie", 1994));
    }

}
