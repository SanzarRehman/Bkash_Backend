package com.example.sanzar.service;

import com.example.sanzar.entity.Customer;
import com.example.sanzar.error.CustomerNotFound;
import com.example.sanzar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerlist() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchCustomerbyid(Long customertId) throws CustomerNotFound {
        Optional<Customer> customer= customerRepository.findById(customertId);
        if(!customer.isPresent())
        {
            throw new CustomerNotFound("Customer not found");
        }
        return customer.get();
    }

    @Override
    public Customer deleteCustomer(Long customerID) {
        customerRepository.deleteById(customerID);
        return null;
    }

    @Override
    public Customer updateCustomer(Long customerID, Customer customer) {
        Customer depDB= customerRepository.findById(customerID).get();
        if(Objects.nonNull(customer.getCustomerName()) &&
                 !"".equalsIgnoreCase(customer.getCustomerName())){
            depDB.setCustomerName((customer.getCustomerName()));

        }
        if(Objects.nonNull(customer.getCustomerCode()) &&
                !"".equalsIgnoreCase(customer.getCustomerCode())){
            depDB.setCustomerCode((customer.getCustomerCode()));

        }
        if(Objects.nonNull(customer.getCustomerAddresss()) &&
                !"".equalsIgnoreCase(customer.getCustomerAddresss())) {
            depDB.setCustomerAddresss((customer.getCustomerAddresss()));
        }

            if (Objects.nonNull(customer.getPhone()) &&
                    !"".equalsIgnoreCase(Integer.toString(customer.getPhone()))) {
                depDB.setPhone((customer.getPhone()));
            }


                if (Objects.nonNull(customer.getPin()) &&
                        !"".equalsIgnoreCase(Integer.toString(customer.getPin()))) {
                    depDB.setPin((customer.getPin()));
                }


                    if (Objects.nonNull(customer.getBalance()) &&
                            !"".equalsIgnoreCase(Integer.toString(customer.getBalance()))) {
                        depDB.setBalance((customer.getBalance()));


                    }
                    return customerRepository.save(depDB);
                }

                @Override
                public Customer updateBalance (Long phone, Customer customer){
                    Customer depDB = customerRepository.findById(phone).get();
                    if (Objects.nonNull(customer.getCustomerName()) &&
                            !"".equalsIgnoreCase(customer.getCustomerName())) {
                        depDB.setCustomerName((customer.getCustomerName()));

                    }
                    if (Objects.nonNull(customer.getCustomerCode()) &&
                            !"".equalsIgnoreCase(customer.getCustomerCode())) {
                        depDB.setCustomerCode((customer.getCustomerCode()));

                    }
                    if (Objects.nonNull(customer.getCustomerAddresss()) &&
                            !"".equalsIgnoreCase(customer.getCustomerAddresss())) {
                        depDB.setCustomerAddresss((customer.getCustomerAddresss()));

                    }
                    return customerRepository.save(depDB);
                }

                @Override
                public Customer fetchCustomerByName (String customerName){
                    return customerRepository.findByCustomerName(customerName);
                }

                @Override
                public Customer fetchCustomerByEmail (String customerEmail){
                    return customerRepository.findByEmail(customerEmail);
                }

                @Override
                public Customer fetchbyEmailAndPin (Long customerPin){
                    return null;
                }


            }
