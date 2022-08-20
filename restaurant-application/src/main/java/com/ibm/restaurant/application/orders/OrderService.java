package com.ibm.restaurant.application.orders;

import com.ibm.restaurant.domain.menu.IMenuItemRepository;
import com.ibm.restaurant.domain.menu.MenuItem;
import com.ibm.restaurant.domain.orders.IOrderRepository;
import com.ibm.restaurant.domain.orders.Order;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ITableRepository tableRepository;
    @Autowired
    private IMenuItemRepository menuItemRepository;
    @Autowired
    private IOrderRepository orderRepository;


    public Order placeOrder(final Long tableId, List<Long> menuItems) {
        Order order = new Order(OrderStatus.IN_PREPARATION);
        Table table = tableRepository.getTableById(tableId);

        order.setTable(table);
        addMenuItemsToOrder(order, menuItems);
        return orderRepository.placeOrder(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    private void addMenuItemsToOrder(Order order, List<Long> menuItems) {
        List<MenuItem> menuItemsFromDb = new ArrayList<>();

        for(Long item : menuItems) {
            MenuItem menu = menuItemRepository.findById(item);
            menuItemsFromDb.add(menu);
        }
        menuItemsFromDb.forEach(item -> order.addMenuItem(item));
    }
}