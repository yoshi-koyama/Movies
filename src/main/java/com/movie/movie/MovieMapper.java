package com.movie.movie;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movie> findById(Integer id);

    @Select("SELECT * FROM movies WHERE title LIKE CONCAT(#{prefix}, '%')")
    Optional<Movie> findByMovieStartsWith(String prefix);

    @Select("SELECT * FROM movies WHERE release_year BETWEEN #{startYear} AND #{endYear}")
    Optional<Movie> findByYear(@RequestParam Integer startYear, Integer endYear);
}

