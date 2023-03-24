package com.example.cinemaAppBackend.DTOs;


import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ShowDTO {


    private long showId;

    private  String date;
    @NotNull
    @NotEmpty(message = "start time required")
    private String startTime;

    @NotNull
    @NotEmpty(message = "end time required")
    private String endTime;

    @NotNull
    @NotEmpty(message = "cinema Id required")
    private int cinemaId;

    @NotNull
    @NotEmpty(message = "Movie Id required")
    private long movieId;

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public ShowDTO(){

    }
    public ShowDTO(String date, String startTime, String endTime, int cinemaId, long movieId) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinemaId = cinemaId;
        this.movieId = movieId;
    }
}
