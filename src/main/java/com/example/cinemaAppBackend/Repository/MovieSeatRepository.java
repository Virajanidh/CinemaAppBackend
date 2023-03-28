package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.MovieSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSeatRepository extends JpaRepository<MovieSeatEntity,Long> {
}
