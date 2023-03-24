package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.DTOs.ShowDTO;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.ShowEntity;
import com.example.cinemaAppBackend.Mappers.MovieMapper;
import com.example.cinemaAppBackend.Mappers.ShowMapper;
import com.example.cinemaAppBackend.Repository.MovieRepository;
import com.example.cinemaAppBackend.Repository.ShowRepository;
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
    private ShowRepository showRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private ShowMapper showMapper;

    public List<MovieEntity> getMovies(){
        return movieRepository.findAll();
    }

    public Optional<MovieEntity> getMovie(Long id){
        return  movieRepository.findById(id);
    }

    @Transactional
    public MovieEntity addMovie(MovieDTO movieDTO){
        MovieEntity movieEntity =new MovieEntity();
        ShowEntity showEntity = new ShowEntity();
        int currentCinemaId=Integer.parseInt(movieDTO.getCurrentCinemaUserid());

        //BeanUtils.copyProperties(cinemaUserDTO, cinemaUserEntity);
        movieEntity = movieMapper.mapIn(movieDTO);
        System.out.println(movieEntity);
        movieRepository.save(movieEntity);
        long movieId = movieEntity.getMovieId();
        if(movieDTO.getShowDays() !=null){
            for (String str : movieDTO.getShowDays()) {
                if(movieDTO.getShowTimes()!=null){
                    for(List<String> ar: movieDTO.getShowTimes()){

                            showEntity =showMapper.mapIn(new ShowDTO(str, ar.get(0), ar.get(1), currentCinemaId, movieId));
                            showRepository.save(showEntity);
                    }
                }
            }
        }
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
     public List<MovieEntity> getMovieFromCinema(int cinemaId){
        return movieRepository.findByCinemaId(cinemaId);
     }
}
