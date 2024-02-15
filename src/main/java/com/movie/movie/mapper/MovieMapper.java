package com.movie.movie.mapper;

import com.movie.movie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movie> findById(Integer id);

    @Select("SELECT * FROM movies WHERE title LIKE CONCAT(#{startsWith}, '%')")
    List<Movie> findByMovieStartsWith(String startsWith);

    @Select("SELECT * FROM movies WHERE release_year BETWEEN #{startYear} AND #{endYear}")
    List<Movie> findByYear(Integer startYear, Integer endYear);
}

