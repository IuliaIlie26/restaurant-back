package com.ibm.restaurant.infrastructure.reservation;

import com.ibm.restaurant.domain.reservations.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReservationRepositorySdj extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByClientNameContains(String clientName);

}
