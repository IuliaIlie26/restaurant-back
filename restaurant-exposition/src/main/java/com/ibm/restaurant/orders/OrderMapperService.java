package com.ibm.restaurant.orders;

import com.ibm.restaurant.domain.orders.Order;
import com.ibm.restaurant.menu.MenuItemMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderMapperService {

    @Autowired
    private MenuItemMapperService menuItemMapperService;

    public OrderDto mapFromDomain(final Order order) {
        OrderDto output = new OrderDto();
        if(order != null) {
            output.orderId = order.getOrderId();
            output.orderStatus = order.getOrderStatus().toString();
            output.tableId = order.getTable().getId();
            output.menuItems =  order.getMenuItems().stream().map(menuItemMapperService::mapFromDomain).collect(Collectors.toSet());
        }
        return output;
    }
}