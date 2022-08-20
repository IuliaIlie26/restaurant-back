package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepositorySdj extends JpaRepository<Order, Long> {
}
