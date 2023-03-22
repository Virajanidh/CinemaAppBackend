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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowMapper showMapper;

    public ShowEntity addShow(ShowDTO showDTO){
        ShowEntity showEntity =new ShowEntity();
        //BeanUtils.copyProperties(cinemaUserDTO, cinemaUserEntity);
        showEntity = showMapper.mapIn(showDTO);
        showRepository.save(showEntity);
        return  showEntity;
    }

    public ShowEntity updateShow(ShowDTO showDTO, Long id){
       ShowEntity showEntity =new ShowEntity();
       Optional showEntityoptional= showRepository.findById(id);
        if (showEntityoptional.isPresent()) {
            showEntity = (ShowEntity) showEntityoptional.get();
        }
        if(showDTO.getDate() !=null){showEntity.setDate(showDTO.getDate());}
        if(showDTO.getStartTime() !=null){showEntity.setStartTime(showDTO.getStartTime());}
        if(showDTO.getEndTime() !=null){showEntity.setEndTime(showDTO.getEndTime());}

        showEntity.setShowId(id);
        showRepository.save(showEntity);
        return  showEntity;
    }

    public List<ShowEntity> findShowsByMovieId(Long movieId){
        return  showRepository.findAllByMovieEntityMovieId(movieId);
    }

    public String deleteShow(Long id){
        showRepository.deleteById(id);
        return id + " deleted";
    }

    public void deleteShowbyMovieID(Long movieId){
        showRepository.deleteAllByMovieEntityMovieId(movieId);
    }


}
