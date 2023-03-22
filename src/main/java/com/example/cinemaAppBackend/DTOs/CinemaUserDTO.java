package com.example.cinemaAppBackend.DTOs;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CinemaUserDTO {

    @NotNull
    @NotEmpty(message = "{registration.validation.name}")
    private String name;

    @Min(value = 0, message = "TotalSeats must be greater than or equal to {value}")
    private int totalSeats;

    @NotNull
    @NotEmpty(message = "{registration.validation.Password}")
    private String password;

    @NotNull
    @NotEmpty(message = "{registration.validation.Email}")
    private String email;

    @NotNull
    @NotEmpty(message = "{registration.validation.City}")
    private String city;
    private List<ShowDTO> showDTOList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ShowDTO> getShowDTOList() {
        return showDTOList;
    }

    public void setShowDTOList(List<ShowDTO> showDTOList) {
        this.showDTOList = showDTOList;
    }

    public CinemaUserDTO(){

    }

    @Override
    public String toString() {
        return "CinemaUserDTO{" +
                "name='" + name + '\'' +
                ", totalSeats=" + totalSeats +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", showDTOList=" + showDTOList +
                '}';
    }
}
