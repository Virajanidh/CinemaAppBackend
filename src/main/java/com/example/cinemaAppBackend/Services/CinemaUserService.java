package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.Exceptions.UserAlreadyExistException;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import org.springframework.stereotype.Service;


public interface CinemaUserService {

    public CinemaUserEntity register(final CinemaUserDTO cinemaUserDTO) throws UserAlreadyExistException;
//public void register(final CinemaUserDTO cinemaUserDTO);
    public boolean checkIfUserExist(String Email);
    public CinemaUserEntity updateProfile(CinemaUserDTO cinemaUserDTO, int id);

    public CinemaUserEntity getProfileInfo(String email);
}
