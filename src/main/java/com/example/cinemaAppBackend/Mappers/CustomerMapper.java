package com.example.cinemaAppBackend.Mappers;

import com.example.cinemaAppBackend.DTOs.MovieDTO;
import com.example.cinemaAppBackend.JPA.CustomerEntity;
import com.example.cinemaAppBackend.JPA.MovieEntity;
import com.example.cinemaAppBackend.JPA.ShowEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {

    public CustomerEntity mapIn(String name, String nic, String customerEmail){
        CustomerEntity temp=new CustomerEntity();
        temp.setNic(nic);
        temp.setCustomerEmail(customerEmail);
        temp.setCustomerName(name);
        return temp;
    }
}
