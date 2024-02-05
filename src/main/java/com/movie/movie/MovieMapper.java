package com.movie.movie;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Movie findById(@RequestParam Integer id);

    @Select("SELECT * FROM movies WHERE title LIKE CONCAT(#{prefix}, '%')")
    List<Movie> findByMovieStartsWith(String prefix);


}

