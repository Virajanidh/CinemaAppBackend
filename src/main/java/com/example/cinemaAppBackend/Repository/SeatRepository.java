package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity,Long> {

    @Query(value="select m.title, s.seat_type,s.no_of_seats,p.price,s.seat_id,p.movie_seat_id\n" +
            "from movie as m ,seat as s,movie_seat_entity as p\n" +
            "where s.cinema_id= :cid and s.seat_id=p.seat_id\n" +
            "and p.movie_id=m.movie_id ORDER BY m.title ASC",nativeQuery = true)
    public List<Object[]> findSeatDetailForCinema(@Param("cid")int cinemaId);

//    @Query(value = "update movie_seat_entity  set price =250 where seat_id=:sid",nativeQuery = true)
//    public List<Object[]> updateSeatprice(@Param("sid") long seatId);
//
//    @Query(value = "",nativeQuery = true)
//    public List<Object[]> updateSeatNo(@Param("sid") long seatId,@Param("cid")int cinemaId);
}
