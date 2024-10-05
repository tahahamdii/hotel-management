package tn.taha.ms_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.taha.ms_reservation.entities.Reservation;
import tn.taha.ms_reservation.entities.enums.reservationStatus;

import java.util.List;

@Repository
public interface reservationRepository extends JpaRepository<Reservation,Integer> {

    List<Reservation> findByStatus (reservationStatus status);
}