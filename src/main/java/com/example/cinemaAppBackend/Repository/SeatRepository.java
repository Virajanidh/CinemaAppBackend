package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity,Long> {
}
