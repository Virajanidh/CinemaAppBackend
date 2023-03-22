package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.example.cinemaAppBackend.Repository.CinemaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CinemaUserRepository cinemaUserRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
       final CinemaUserEntity cinemaUser = cinemaUserRepository.findByEmail(email);
        if (cinemaUser == null) {
            throw new UsernameNotFoundException(email);
        }
        System.out.println(cinemaUser);
        /*UserDetails user = User.withUsername(cinemaUser.getEmail())
                .password(cinemaUser.getPassword())
                .authorities("USER").build();*/
        return new CustomUserDetails(cinemaUser);
    }
}
