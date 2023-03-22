package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.Mappers.MovieMapper;
import com.example.cinemaAppBackend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    public List<MovieEntity> getMovies(){
        return movieRepository.findAll();
    }

    public Optional<MovieEntity> getMovie(Long id){
        return  movieRepository.findById(id);
    }

    @Transactional
    public MovieEntity addMovie(MovieDTO movieDTO){
        MovieEntity movieEntity =new MovieEntity();
        //BeanUtils.copyProperties(cinemaUserDTO, cinemaUserEntity);
        movieEntity = movieMapper.mapIn(movieDTO);
        System.out.println(movieEntity);
        movieRepository.save(movieEntity);
        return  movieEntity;
    }

    public MovieEntity updateMovie(MovieDTO movieDTO, Long id){
        MovieEntity movieEntity =new MovieEntity();
        //BeanUtils.copyProperties(cinemaUserDTO, cinemaUserEntity);
        movieEntity = movieMapper.mapIn(movieDTO);
        movieEntity.setMovieId(id);
        movieRepository.save(movieEntity);
        return  movieEntity;
    }

    public String deleteMovie(long id){
        movieRepository.deleteById(id);
        return id+"deleted ";
    }
}
