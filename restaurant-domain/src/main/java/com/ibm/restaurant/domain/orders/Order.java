package com.ibm.restaurant.domain.orders;

import com.ibm.restaurant.domain.menu.MenuItem;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "TABLE_ID", referencedColumnName = "TABLE_ID")
    private com.ibm.restaurant.domain.tables.Table table;

    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

    @ManyToMany
    @JoinTable(
            name = "ORDERS_MENU_ITEMS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ITEM_ID"))
    private Set<MenuItem> menuItems = new HashSet<>();

    public Order(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public com.ibm.restaurant.domain.tables.Table getTable() {
        return table;
    }

    public void setTable(com.ibm.restaurant.domain.tables.Table table) {
        this.table = table;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<MenuItem> getMenuItems() {
        return Collections.unmodifiableSet(menuItems);
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

}
