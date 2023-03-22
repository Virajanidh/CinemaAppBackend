package com.example.cinemaAppBackend.JPA;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="show")
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showId;

    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private  LocalDateTime date;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
  //  @JsonBackReference
    private CinemaUserEntity cinemaUserEntity;

    @ManyToOne
    @JoinColumn(name = "movie_id")
  //  @JsonBackReference
    private  MovieEntity movieEntity;

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public CinemaUserEntity getCinemaUserEntity() {
        return cinemaUserEntity;
    }

    public void setCinemaUserEntity(CinemaUserEntity cinemaUserEntity) {
        this.cinemaUserEntity = cinemaUserEntity;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
