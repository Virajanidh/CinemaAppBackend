package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.BookingEntity;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    BookingEntity findByPaymentId(long paymentId);

    @Query(value = "SELECT COALESCE( SUM(no_of_booked_seats), 0) AS total_seats\n" +
            "FROM booking where show_id= :shId and seat_id= :sId and cinema_id= :cId",nativeQuery = true)
    public int getTotalBookedSeats(@Param("shId") long showId,@Param("sId") long seatId,@Param("cId") int cinemaId);

    @Query(value="select no_of_seats from seat where seat_id= :sId and cinema_id= :cId",nativeQuery = true)
    public int getDefaultSeatAvailability(@Param("sId") long seatId,@Param("cId") int cinemaId);

    @Query(value="\n" +
            "select m.title,s.date,s.start_time,SUM(b.no_of_booked_seats) AS total_booked_seats,se.seat_type, se.no_of_seats as total_Available_seats\n" +
            "from movie as m, seat as se , show as s,booking as b,cinema_user as c\n" +
            "where b.seat_id=se.seat_id and s.movie_id=m.movie_id\n" +
            "and b.show_id=s.show_id\n" +
            "and s.cinema_id=c.cinema_id\n" +
            "and se.cinema_id=c.cinema_id\n" +
            "and c.cinema_id=:cId\n" +
            "group by m.title,s.date,s.start_time,se.no_of_seats,se.seat_type\n" +
            "order by m.title ASC",nativeQuery = true)
    public List<Object[]> getReservations(@Param("cId") int cinemaId);
}
