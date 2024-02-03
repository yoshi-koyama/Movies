package com.movie.movie;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<Movie> findByMovieStartingWith(String prefix);

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Movie findById(int id);

    @Select("SELECT * FROM movies WHERE publication_year >= #{startYear} AND publication_year <= #{endYear}")
    List<Movie> findByPublication_yearRange(@Param("startYear") int startYear, @Param("endYear") int endYear);
}




