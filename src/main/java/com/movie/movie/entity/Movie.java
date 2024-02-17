package com.movie.movie.entity;

import java.util.Objects;

public class Movie {
    private int id;
    private String title;
    private int release_year;

    public Movie(int id, String title, int release_year) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && release_year == movie.release_year && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, release_year);
    }
}



