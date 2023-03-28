package com.example.cinemaAppBackend.Repository;

import com.example.cinemaAppBackend.JPA.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    CustomerEntity findByNic(String nic);
}
