package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaUserRepository<T,CinemaId> extends JpaRepository<CinemaUserEntity,Integer> {
  CinemaUserEntity findByEmail(String email);
}
