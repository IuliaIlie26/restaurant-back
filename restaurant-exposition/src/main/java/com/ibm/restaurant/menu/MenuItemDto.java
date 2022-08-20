package com.ibm.restaurant.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MenuItemDto {

    @JsonProperty
    public Long id;

    @JsonProperty
    public String itemName;

    @JsonProperty
    public BigDecimal price;

    @JsonProperty
    public String description;

}
