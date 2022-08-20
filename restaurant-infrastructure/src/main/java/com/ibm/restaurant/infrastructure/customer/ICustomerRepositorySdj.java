package com.ibm.restaurant.infrastructure.customer;

import com.ibm.restaurant.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepositorySdj extends JpaRepository<Customer, Long> {

}
