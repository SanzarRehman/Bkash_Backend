package com.example.sanzar.repository;


import com.example.sanzar.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Customer customer =
                com.example.sanzar.entity.Customer.builder()
                .customerName("Mechanical Engineering")
                .customerCode("ME - 011")
                .customerAddresss("Delhi")
                .build();

        entityManager.persist(customer);
    }

    @Test
    public void whenFindById_thenReturnCustomer() {
        Customer customer = customerRepository.findById(1L).get();
        assertEquals(customer.getCustomerName(), "Mechanical Engineering");
    }
}