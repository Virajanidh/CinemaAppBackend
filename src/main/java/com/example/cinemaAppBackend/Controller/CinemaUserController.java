package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.Exceptions.UserAlreadyExistException;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.Mappers.CinemaUserMapper;
import com.example.cinemaAppBackend.Services.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/registration")
@CrossOrigin( origins = "http://localhost:3000/", allowedHeaders = {})
public class CinemaUserController {

    @Autowired
    private CinemaUserService cinemaUserService;

    private CinemaUserMapper cinemaUserMapper;


    @GetMapping
    public String showRegistrationForm(WebRequest request, Model model) {
        CinemaUserDTO  cinemaUserDTO= new CinemaUserDTO();
        model.addAttribute("user", cinemaUserDTO);
        return "Cinema user registration";
    }


//    @CrossOrigin
//    @PostMapping
//    public CinemaUserEntity registerUser(@RequestBody CinemaUserDTO cinemaUserDTO){
//        try{
//           return cinemaUserService.register(cinemaUserDTO);
//
//        } catch (Exception e){
//            CinemaUserEntity temp =new CinemaUserEntity();
//            System.out.println(e);
//            //return temp;
//        }
//
//
//    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody CinemaUserDTO cinemaUserDTO){
            return cinemaUserService.register(cinemaUserDTO);
    }

    @PutMapping("/{id}")
    public CinemaUserEntity updateProfile(@RequestParam("id") int id, CinemaUserDTO cinemaUserDTO){
        return cinemaUserService.updateProfile(cinemaUserDTO,id);
    }

    @GetMapping("/hello")
    public String getMovi(){
        return "this is movie get page";
    }

}
