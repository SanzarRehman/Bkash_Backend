package com.example.sanzar.repository;

import com.example.sanzar.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    public Customer findByCustomerName(String customerName);


      Customer findByEmail(String customerEmail);

}
