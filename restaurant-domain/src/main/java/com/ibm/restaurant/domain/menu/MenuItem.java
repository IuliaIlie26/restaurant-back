package com.ibm.restaurant.domain.menu;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "MENU_ITEMS")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ITEM_ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "DESCRIPTION")
    private String description;

    private MenuItem() {}

    public MenuItem(String itemName, BigDecimal price, String description) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
