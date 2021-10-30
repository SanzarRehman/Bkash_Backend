package com.example.sanzar.service;


import com.example.sanzar.entity.Customer;
import com.example.sanzar.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer =
                Customer.builder()
                .customerName("IT")
                .customerAddresss("Ahmedabad")
                .customerCode("IT-06")
                .customerID(1L)
                .build();

        Mockito.when(customerRepository.findByCustomerName("IT"))
                .thenReturn(customer);

    }

    @Test
    @DisplayName("Get Data based on Valida Customer Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Customer found =
                customerService.fetchCustomerByName(departmentName);

        assertEquals(departmentName, found.getCustomerName());
    }
}