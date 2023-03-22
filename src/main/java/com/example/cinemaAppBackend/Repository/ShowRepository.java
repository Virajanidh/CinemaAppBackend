package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long> {
    List<ShowEntity> findAllByMovieEntityMovieId(Long movieId);


   void deleteAllByMovieEntityMovieId(Long movieId);
}
