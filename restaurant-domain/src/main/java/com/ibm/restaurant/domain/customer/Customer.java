package com.ibm.restaurant.domain.customer;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastname;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade=CascadeType.ALL )
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
