package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.Exceptions.UserAlreadyExistException;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.Mappers.CinemaUserMapper;
import com.example.cinemaAppBackend.Services.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin
public class LoginController {

    @Autowired
    private CinemaUserService cinemaUserService;

//    @CrossOrigin
//    @GetMapping("/login/{email}")
//    public CinemaUserEntity login(@PathVariable("email") String email){
//        return cinemaUserService.getProfileInfo(email);
//    }

    @GetMapping("/login")
    public CinemaUserEntity login(@CurrentSecurityContext(expression="authentication?.name")
                            String username) {
        return cinemaUserService.getProfileInfo(username);
    }

    @GetMapping("/logout/success")
    public String logoutSuccess() {
        return "logout success";
    }

    @PutMapping("login/profile/{id}")
    public CinemaUserEntity updateProfile(@PathVariable("id") int id, @RequestBody CinemaUserDTO cinemaUserDTO) {
      CinemaUserEntity temp = new CinemaUserEntity();
        try{
            return cinemaUserService.updateProfile(cinemaUserDTO,id);
        } catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }

}
