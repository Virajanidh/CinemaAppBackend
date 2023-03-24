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

   // @Column(name = "date", columnDefinition = "TIMESTAMP")
    private  String date;

   // @Column(name = "start_time", columnDefinition = "TIMESTAMP")
    private String startTime;

   // @Column(name = "end_time", columnDefinition = "TIMESTAMP")
    private String endTime;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
