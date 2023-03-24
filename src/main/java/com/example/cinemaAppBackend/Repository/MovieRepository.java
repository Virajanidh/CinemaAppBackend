package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Long> {

//    @Query(
//        value="select distinct \n" +
//                "m \n" +
//                "from MovieEntity as m ,ShowEntity as s,CinemaUserEntity as c\n" +
//                "where m.movieId=s.movieId \n" +
//                "and s.cinemaId=c.cinemaId \n" +
//                "and c.cinemaId= :cinemaId"
//    )
//@Query(
//        value="select  \n" +
//                "m \n" +
//                "from MovieEntity m where m.movieId=11"
//)
//    @Query(
//        "select distinct \n" +
//                "m \n" +
//                "from MovieEntity m ,ShowEntity s,CinemaUserEntity c\n" +
//                "where m.movieId=s.movieId \n" +
//                "and s.cinemaId=c.cinemaId \n" +
//                "and c.cinemaId= :cin"
//    )
    @Query(value="select distinct \n" +
            "m.title, m.description,m.country,\n" +
            "m.language,m.movie_duration,m.movie_id,m.language,m.release_date\n" +
            "from movie as m ,show,cinema_user\n" +
            "where m.movie_Id=show.movie_id \n" +
            "and show.cinema_Id=cinema_user.cinema_Id \n" +
            "and cinema_user.cinema_id= :cin", nativeQuery = true)
public List<MovieEntity> findByCinemaId(@Param("cin") int cinemaId);
}
