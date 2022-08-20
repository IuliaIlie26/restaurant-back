package com.ibm.restaurant.domain.reservations;

import java.util.List;

public interface IReservationRepository {

    Reservation createReservation(Reservation reservation);

    List<Reservation> findAllByClientName(String clientName);
}
