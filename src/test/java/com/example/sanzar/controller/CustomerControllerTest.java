package com.example.sanzar.controller;

import com.example.sanzar.entity.Customer;
import com.example.sanzar.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = com.example.sanzar.entity.Customer.builder()
                .customerAddresss("Ahmedabad")
                .customerCode("IT-06")
                .customerName("IT")
                .customerID(1L)
                .email("sanzarrahman@gmail.com")
                .balance(100)
                .NID(123232354)
                .Phone(01767577571)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Customer inputCustomer = com.example.sanzar.entity.Customer.builder()
                .customerAddresss("Ahmedabad")
                .customerCode("IT-06")
                .customerName("IT")
                .customerID(1L)
                .email("sanzarrahman@gmail.com")
                .balance(100)
                .NID(123232354)
                .Phone(01767577571)
                .build();

        Mockito.when(customerService.saveCustomer(inputCustomer))
                .thenReturn(customer);

        mockMvc.perform(post("/customers")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"customerName\":\"IT\",\n" +
                "\t\"customerAddress\":\"Ahmedabad\",\n" +
                "\t\"customerCode\":\"IT-06\"\n" +
                "\t\"customerEmail\":\"sanzarrahman@gmail.com\"\n" +
                "\t\"customerBalance\":\"100\"\n" +
                "\t\"customerNID\":\"123232354\"\n" +
                "\t\"customerPhone\":\"01767577571\"\n" +

                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(customerService.fetchCustomerbyid(1L))
                .thenReturn(customer);

        mockMvc.perform(get("/customers/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.customerName").
                value(customer.getCustomerName()));
    }
}