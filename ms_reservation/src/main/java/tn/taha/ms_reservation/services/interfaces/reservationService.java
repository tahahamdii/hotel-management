package tn.taha.ms_reservation.services.interfaces;

import tn.taha.ms_reservation.entities.Reservation;
import tn.taha.ms_reservation.entities.enums.reservationStatus;

import java.util.List;

public interface reservationService {
    public Reservation addReservation(int idRoom, Reservation reservation);

    public Reservation getReservation (int id);

    public Reservation update(int id, Reservation newReservation);

    public List<Reservation> all_reservations();
    public List <Reservation> findByStatus (reservationStatus status);
    public boolean DeleteReservation(int id);
}
