package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.menu.MenuItemDto;

import java.util.Set;

public class OrderDto {

    @JsonProperty
    public Long orderId;
    @JsonProperty
    public String orderStatus;
    @JsonProperty
    public Long tableId;
    @JsonProperty
    public Set<MenuItemDto> menuItems;

}
