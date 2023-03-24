package com.example.cinemaAppBackend.Controller;

import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.Services.MovieService;
import com.example.cinemaAppBackend.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@CrossOrigin( allowedHeaders = {})
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowService showService;

    @PostMapping("/movie")
    public MovieEntity addMovie(@RequestBody MovieDTO movieDTO){
        MovieEntity temp = new MovieEntity();
        try{
            return movieService.addMovie(movieDTO);
        } catch (Exception e){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(e);
        }
        return temp;
    }

    @PutMapping("/movie/{id}")
    public MovieEntity editMovie(@PathVariable("id") Long id,@RequestBody MovieDTO movieDTO) {
        MovieEntity temp = new MovieEntity();
        try{
            return movieService.updateMovie(movieDTO,id);
        } catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }


    @GetMapping("/movie")
    public List<MovieEntity> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/movie/{id}")
    public Optional<MovieEntity> getMovie(@PathVariable("id") long id){
        return movieService.getMovie(id);
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable("id") Long id){
       // showService.deleteShowbyMovieID(id);
        return movieService.deleteMovie(id);
    }

    @GetMapping("/movie/cinema/{cinemaId}")
    public List<MovieEntity> getMovieFromCinema(@PathVariable("cinemaId") int cinemaId){
        return movieService.getMovieFromCinema(cinemaId);
    }

}







