package com.ibm.restaurant.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlaceOrderDto {
    @JsonProperty
    public Long tableId;

    @JsonProperty
    public List<Long> menuItems;

}
