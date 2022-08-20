package com.ibm.restaurant.infrastructure.reservation;

import com.ibm.restaurant.domain.reservations.Reservation;
import com.ibm.restaurant.domain.reservations.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepositoryImpl implements IReservationRepository {

    @Autowired
    private IReservationRepositorySdj repositorySdj;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return repositorySdj.save(reservation);
    }

    @Override
    public List<Reservation> findAllByClientName(String clientName) {
        return repositorySdj.findAllByClientNameContains(clientName);
    }

}
