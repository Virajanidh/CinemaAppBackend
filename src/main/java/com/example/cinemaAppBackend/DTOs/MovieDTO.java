package com.example.cinemaAppBackend.DTOs;

import com.example.cinemaAppBackend.JPA.ShowEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class MovieDTO {
    @NotNull
    @NotEmpty(message = "title required")
    private String title;
    @NotNull
    @NotEmpty(message = "description required")
    private String description;
    @NotNull
    @NotEmpty(message = "language required")
    private  String language;
    @NotNull
    @NotEmpty(message = "country required")
    private  String country;
    @NotNull
    @NotEmpty(message = "release date required")
    private LocalDateTime releaseDate;
    @NotNull
    @NotEmpty(message = "movie duration required")
    private String movieDuration;

    private List<ShowDTO> showDTOList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public List<ShowDTO> getShowDTOList() {
        return showDTOList;
    }

    public void setShowDTOList(List<ShowDTO> showDTOList) {
        this.showDTOList = showDTOList;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", releaseDate=" + releaseDate +
                ", movieDuration='" + movieDuration + '\'' +
                ", showDTOList=" + showDTOList +
                '}';
    }
}
