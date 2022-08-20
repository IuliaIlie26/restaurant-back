package com.ibm.restaurant.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.reservations.ReservationDto;

import java.util.Set;

public class TableDto {

    @JsonProperty
    public String capacity;
    @JsonProperty
    public String status;
    @JsonProperty
    public long id;
    @JsonProperty
    public Set<ReservationDto> reservationDto;
}
