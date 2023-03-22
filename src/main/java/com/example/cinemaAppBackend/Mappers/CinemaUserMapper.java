package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CinemaUserMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CinemaUserEntity mapIn(CinemaUserDTO cinemaUserDTO){
        CinemaUserEntity temp = new CinemaUserEntity();
        temp.setName(cinemaUserDTO.getName());
        temp.setCity(cinemaUserDTO.getCity());
        temp.setEmail(cinemaUserDTO.getEmail());
        temp.setTotalSeats(cinemaUserDTO.getTotalSeats());
        temp.setPassword(encodePassword(cinemaUserDTO));
        return temp;
    }

    public CinemaUserDTO mapOut(CinemaUserEntity cinemaUserEntity){
        CinemaUserDTO temp = new CinemaUserDTO();
        temp.setName(cinemaUserEntity.getName());
        temp.setCity(cinemaUserEntity.getCity());
        temp.setEmail(cinemaUserEntity.getEmail());
        temp.setTotalSeats(cinemaUserEntity.getTotalSeats());
        temp.setPassword(cinemaUserEntity.getPassword());
        return temp;
    }

    public String encodePassword(CinemaUserDTO source){
        String encodedPassword = passwordEncoder.encode(source.getPassword());
       return encodedPassword;
    }
}
