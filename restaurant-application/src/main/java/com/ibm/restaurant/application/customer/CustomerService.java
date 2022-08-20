package com.ibm.restaurant.application.customer;

import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

}
