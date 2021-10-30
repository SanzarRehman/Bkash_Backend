package com.example.sanzar.service;

import com.example.sanzar.entity.Customer;
import com.example.sanzar.error.CustomerNotFound;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);

    List<Customer> fetchCustomerlist();

   public Customer fetchCustomerbyid(Long customerId) throws CustomerNotFound;

    Customer deleteCustomer(Long customerID);

   public Customer updateCustomer(Long customerID, Customer customer);
    public Customer updateBalance(Long phone, Customer customer);




    Customer fetchCustomerByName(String customerName);


    Customer fetchCustomerByEmail(String customerEmail);


    Customer  fetchbyEmailAndPin(Long customerPin);
}
