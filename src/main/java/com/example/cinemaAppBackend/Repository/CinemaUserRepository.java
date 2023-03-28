package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaUserRepository<T,CinemaId> extends JpaRepository<CinemaUserEntity,Integer> {
  CinemaUserEntity findByEmail(String email);

  @Query(value="select distinct \n" +
          "m.title, m.description,m.country,\n" +
          "m.language,m.movie_duration,m.movie_id,m.language,m.release_date\n" +
          "from movie as m ,show,cinema_user\n" +
          "where m.movie_Id=show.movie_id \n" +
          "and show.cinema_Id=cinema_user.cinema_Id \n" +
          "and cinema_user.cinema_id= :cin", nativeQuery = true)
  public List<MovieEntity> findByCinemaId(@Param("cin") int cinemaId);
}
