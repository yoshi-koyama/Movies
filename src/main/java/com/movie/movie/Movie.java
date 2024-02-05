package com.movie.movie;

public class Movie {
    private Integer id;
    private String title;
    private Integer release_year;

    public Movie(Integer id, String title, Integer release_year) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }
}




