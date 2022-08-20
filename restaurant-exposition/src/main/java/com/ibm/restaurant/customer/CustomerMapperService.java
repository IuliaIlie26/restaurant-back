package com.ibm.restaurant.customer;

import com.ibm.restaurant.domain.customer.Address;
import com.ibm.restaurant.domain.customer.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperService {


    public CustomerDto mapFromDomain(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.customerId = customer.getCustomerId();
        customerDto.lastname = customer.getLastname();
        customerDto.name = customer.getName();
        customerDto.addressDto = mapAddressFromDomain(customer.getAddress());
        return customerDto;
    }

    private AddressDto mapAddressFromDomain(Address address) {
        AddressDto dto = new AddressDto();
        dto.addressLine1 = address.getAddressLine1();
        return dto;
    }

    public Customer mapToDomain(CustomerDto dto) {
        Address address = null;
        if (dto.addressDto != null) {
            address = mapAddressDtoToDomain(dto.addressDto);
        }
        Customer customer = new Customer();
        customer.setName(dto.name);
        customer.setLastname(dto.lastname);
        customer.setAddress(address);
        return customer;
    }

    private Address mapAddressDtoToDomain(AddressDto addressDto) {
        Address address = new Address();
        address.setAddressLine1(addressDto.addressLine1);
        return address;
    }
}