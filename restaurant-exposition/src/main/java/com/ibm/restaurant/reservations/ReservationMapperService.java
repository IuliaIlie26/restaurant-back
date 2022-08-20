package com.ibm.restaurant.reservations;

import com.ibm.restaurant.domain.reservations.Reservation;
import com.ibm.restaurant.domain.tables.Table;
import com.ibm.restaurant.tables.TableDto;
import com.ibm.restaurant.tables.TableMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class ReservationMapperService {

    public Reservation mapToDomain(final ReservationDto dto) {
        if (dto != null) {
            Reservation reservation = new Reservation();
            reservation.setClientName(dto.clientName);
            reservation.setPersonNo(dto.personNo);
            return reservation;
        }
        return null;
    }

    public ReservationDto mapFromDomain(Reservation reservation) {
        if (reservation != null) {
            ReservationDto dto = new ReservationDto();
            dto.reservationId = reservation.getReservationId();
            dto.tableDto = mapTableFromDomain(reservation.getTable());
            dto.clientName = reservation.getClientName();
            dto.personNo = reservation.getPersonNo();
            return dto;
        }

        return null;
    }

    public TableDto mapTableFromDomain(Table table) {
        TableDto dto = new TableDto();
        dto.capacity = table.getCapacity();
        dto.status = table.getStatus().name();
        return dto;
    }
}

