package com.ibm.restaurant.orders;

import com.ibm.restaurant.application.orders.OrderService;
import com.ibm.restaurant.domain.orders.Order;
import com.ibm.restaurant.menu.MenuItemMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderMapperService orderMapperService;
    @Autowired
    private MenuItemMapperService menuItemMapperService;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(@RequestBody final PlaceOrderDto placeOrderDto) {
        Order order = orderService.placeOrder(placeOrderDto.tableId, placeOrderDto.menuItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMapperService.mapFromDomain(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> result = orderService.getOrders().stream()
                .map(orderMapperService::mapFromDomain)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
