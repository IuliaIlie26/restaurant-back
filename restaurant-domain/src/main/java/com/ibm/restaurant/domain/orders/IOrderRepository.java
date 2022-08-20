package com.ibm.restaurant.domain.orders;

import java.util.List;

public interface IOrderRepository {

    Order placeOrder(final Order order);

    Order updateOrder(final Order order);

    Order cancelOrder(final Order order);

    List<Order> findAll();

}
