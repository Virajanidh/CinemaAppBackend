package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.Exceptions.UserAlreadyExistException;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.Mappers.CinemaUserMapper;
import com.example.cinemaAppBackend.Repository.CinemaUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("CinemaUserService")
public class CinemaUserServiceImpl implements CinemaUserService {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CinemaUserMapper cinemaUserMapper;

    public CinemaUserEntity getProfileInfo(String email){
        return cinemaUserRepository.findByEmail(email);
    }

    @Override
    public ResponseEntity<?> register(CinemaUserDTO cinemaUserDTO) throws UserAlreadyExistException{
        if(checkIfUserExist(cinemaUserDTO.getEmail())){
            String errorMessage = "Email address already exists";
            return ResponseEntity.badRequest().body(errorMessage);
            // throw new UserAlreadyExistException("User already exists for this email");
        }
        CinemaUserEntity cinemaUserEntity =new CinemaUserEntity();
        //BeanUtils.copyProperties(cinemaUserDTO, cinemaUserEntity);
        cinemaUserEntity = cinemaUserMapper.mapIn(cinemaUserDTO);
        cinemaUserRepository.save(cinemaUserEntity);
        return  ResponseEntity.ok(cinemaUserEntity);
    }

    @Override
    public boolean checkIfUserExist(String Email) {
       return cinemaUserRepository.findByEmail(Email) !=null ? true : false;
       // return false;
    }

    public void encodePassword(CinemaUserDTO source, CinemaUserEntity target){
        String encodedPassword = passwordEncoder.encode(source.getPassword());
        target.setPassword(encodedPassword);
    }

    public CinemaUserEntity updateProfile(CinemaUserDTO cinemaUserDTO, int id){
        CinemaUserEntity cinemaUserEntity =new CinemaUserEntity();
        cinemaUserEntity = cinemaUserMapper.mapIn(cinemaUserDTO);
        cinemaUserEntity.setCinemaId(id);
        cinemaUserRepository.save(cinemaUserEntity);
        return cinemaUserEntity;
    }
}
