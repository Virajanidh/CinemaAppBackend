package com.example.cinemaAppBackend.Services;

import com.example.cinemaAppBackend.DTOs.CinemaUserDTO;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private CinemaUserEntity cinemaUserEntity;
    public CustomUserDetails(CinemaUserEntity cinemaUserEntity) {
        super();
        this.cinemaUserEntity = cinemaUserEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return cinemaUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return cinemaUserEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
