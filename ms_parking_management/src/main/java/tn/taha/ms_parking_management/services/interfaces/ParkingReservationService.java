package tn.taha.ms_parking_management.services.interfaces;

import tn.taha.ms_parking_management.entities.ParkingReservation;

import java.util.List;
import java.util.Optional;


public interface ParkingReservationService {
    ParkingReservation addParkingReservation(ParkingReservation parkingReservation);

    Optional<ParkingReservation> getParkingReservation(String id);

    List<ParkingReservation> getAllParkingReservations();

    boolean deleteParkingReservation(String id);

    void confirmParkingReservation(String id);

    void declineParkingReservation(String id);



}
