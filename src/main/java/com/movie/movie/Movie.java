package com.movie.movie;

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
}



