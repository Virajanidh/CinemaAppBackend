package com.example.cinemaAppBackend.JPA;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CinemaUser")
public class CinemaUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaId;
    private String name;
    private int totalSeats;
    private String password;

    @Column(unique = true)
    private String email;
    private String city;

   // @JsonManagedReference
   /// @OneToMany(mappedBy = "cinemaUserEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @OneToMany(mappedBy = "cinemaUserEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList;

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaUserEntity",cascade = CascadeType.ALL)
    private List<SeatEntity> seatEntityList;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

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

    public List<ShowEntity> getShowEntityList() {
        return showEntityList;
    }

    public void setShowEntityList(List<ShowEntity> showEntityList) {
        this.showEntityList = showEntityList;
    }
}
