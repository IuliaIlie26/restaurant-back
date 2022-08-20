package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.orders.IOrderRepository;
import com.ibm.restaurant.domain.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements IOrderRepository {

    @Autowired
    private IOrderRepositorySdj repositorySdj;

    @Override
    public Order placeOrder(Order order) {
        return repositorySdj.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return repositorySdj.save(order);
    }

    @Override
    public Order cancelOrder(Order order) {
        return repositorySdj.save(order);
    }

    @Override
    public List<Order> findAll() {
        return repositorySdj.findAll();
    }
}
