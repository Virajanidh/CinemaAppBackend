package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.DTOs.ShowDTO;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.ShowEntity;
import com.example.cinemaAppBackend.Mappers.CinemaUserMapper;
import com.example.cinemaAppBackend.Services.CinemaUserService;
import com.example.cinemaAppBackend.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin( allowedHeaders = {})
public class ShowController {
    @Autowired
    private ShowService showService;




    @GetMapping("/show/{id}")
    public List<ShowEntity> findShowsByMovieId(@PathVariable Long id) {
        return showService.findShowsByMovieId(id);
    }

    @PostMapping("/show")
    public ShowEntity addShow(@RequestBody ShowDTO showDTO){
        ShowEntity temp =new ShowEntity();
        try{
            return showService.addShow(showDTO);
        } catch (Exception e){
            System.out.println(e);
            return temp;
        }

    }

    @PutMapping("/show/{showId}")
    public ShowEntity editShow(@PathVariable("showId") Long id, @RequestBody ShowDTO showDTO) {
        ShowEntity temp = new ShowEntity();
        try{
            return showService.updateShow(showDTO,id);
        } catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }

    @DeleteMapping("show/{id}")
    public String deleteShow(@PathVariable("id") long id){
        return showService.deleteShow(id);
    }

}
