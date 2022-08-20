package com.ibm.restaurant.infrastructure.customer;

import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private ICustomerRepositorySdj repositorySdj;

    @Override
    public Customer findById(Long id) {
        return repositorySdj.findById(id).orElse(null);
    }


    @Override
    public void save(Customer customer) {
        repositorySdj.save(customer);
    }
}
