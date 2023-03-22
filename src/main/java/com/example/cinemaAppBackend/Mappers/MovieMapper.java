package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.DTOs.ShowDTO;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.ShowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    private ShowMapper showMapper;
    public MovieEntity mapIn(MovieDTO movieDTO){
        MovieEntity temp = new MovieEntity();
        temp.setCountry(movieDTO.getCountry());
        temp.setDescription(movieDTO.getDescription());
        temp.setLanguage(movieDTO.getLanguage());
        temp.setMovieDuration(movieDTO.getMovieDuration());
        temp.setTitle(movieDTO.getTitle());
        temp.setReleaseDate(movieDTO.getReleaseDate());

        List<ShowEntity> showEntityList = null;

        if(movieDTO.getShowDTOList() !=null){
            for (ShowDTO element : movieDTO.getShowDTOList()) {
                ShowEntity  temp2 =new ShowEntity();
                temp2 = showMapper.mapIn(element);
                showEntityList.add(temp2);
            }
        }


        temp.setShowEntityList(showEntityList);
        return temp;
    }

    public MovieDTO mapOut(MovieEntity movieEntity){
        MovieDTO temp = new MovieDTO();
        temp.setCountry(movieEntity.getCountry());
        temp.setDescription(movieEntity.getDescription());
        temp.setLanguage(movieEntity.getLanguage());
        temp.setMovieDuration(movieEntity.getMovieDuration());
        temp.setTitle(movieEntity.getTitle());
        temp.setReleaseDate(movieEntity.getReleaseDate());
        List<ShowDTO> showDTOList = null;

        if(movieEntity.getShowEntityList() !=null) {
            for (ShowEntity element : movieEntity.getShowEntityList()) {
                ShowDTO temp2 = new ShowDTO();
                temp2 = showMapper.mapOut(element);
                showDTOList.add(temp2);
            }
        }

        temp.setShowDTOList(showDTOList);


        return temp;
    }
}
