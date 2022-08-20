package com.ibm.restaurant.domain.customer;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }
}
