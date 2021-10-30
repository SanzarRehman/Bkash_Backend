package com.example.sanzar.controller;

import com.example.sanzar.entity.Customer;
import com.example.sanzar.error.CustomerNotFound;
import com.example.sanzar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customers")
public Customer saveCustomer(@Valid @RequestBody Customer customer)
{
    return customerService.saveCustomer(customer);

}

@GetMapping("/customers")
    public List<Customer> fetchCustomerlist()
{
    return customerService.fetchCustomerlist();
}

@GetMapping("/customers/{id}")
public Customer fetchCustomerbyid(@PathVariable("id") Long customerId) throws CustomerNotFound {

return customerService.fetchCustomerbyid(customerId);

}
    @GetMapping("/customers/email/{email}")
    public Customer fetchCustomerByEmail(@PathVariable("email") String customerEmail) {
        return customerService.fetchCustomerByEmail(customerEmail);
    }


//    @GetMapping("/customers/{phone}")
//    public Customer fetchCustomerbyPhone(@PathVariable("phone") Long customerPhone) throws CustomerNotFound {
//
//        return customerService.fetchCustomerbyid(customerPhone);

//    }
    @GetMapping("/customers/{pin}")
    public Customer fetchCustomerbyPin(@PathVariable Long customerPin) throws CustomerNotFound {

        return customerService.fetchbyEmailAndPin(customerPin);

    }
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable("id")Long customerID)
    {
        customerService.deleteCustomer(customerID);
        return "deleted";
    }
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable("id")Long customerID, @RequestBody Customer customer)
    {

    return customerService.updateCustomer(customerID,customer);
    }
    @GetMapping("/customers/name/{name}")
    public Customer fetchCustomerByName(@PathVariable("name") String customerName) {
        return customerService.fetchCustomerByName(customerName);
    }

}

