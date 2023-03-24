package com.example.cinemaAppBackend.config;


import com.example.cinemaAppBackend.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class NewSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    //private CorsConfigurationSource corsConfigurationSource;
    private CorsConfig corsConfig;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                //.cors().configurationSource(corsConfigurationSource).and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user/**","/hello").permitAll()
//            //   .authenticated()
//                .antMatchers("/login/**", "/movie","/movie/**","/show","/seat")
//                .hasAuthority("USER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
        http.cors()
                //.configurationSource(corsConfig.corsConfigurationSource())
                .and()
                .csrf().disable()
               // .cors().configurationSource(corsConfig.corsConfigurationSource()).and()
                .authorizeRequests()
                .antMatchers("/user/registration","/user/**","hello").permitAll() // Allow any user to access this endpoint
                .antMatchers("/login").authenticated() // Only authenticated users can access this endpoint
                .antMatchers("/movie","/movie/**","/show","/seat","movie/cinema/**").hasAuthority("USER") // Requires "USER" authority for these endpoints
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .httpBasic();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }




    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return  provider;
    }


}
