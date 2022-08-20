package com.ibm.restaurant.reservations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.restaurant.tables.TableDto;

public class ReservationDto {

    @JsonProperty
    public Long reservationId;
    @JsonProperty
    public Long tableId;
    @JsonProperty
    public TableDto tableDto;
    @JsonProperty
    public String clientName;
    @JsonProperty
    public Integer personNo;

}
