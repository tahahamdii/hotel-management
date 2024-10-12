package tn.taha.ms_parking_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.taha.ms_parking_management.entities.ParkingReservation;
import tn.taha.ms_parking_management.repositories.ParkingReservationRepository;
import tn.taha.ms_parking_management.services.interfaces.ParkingReservationService;


@Service
public class ParkingReservationServiceImp implements ParkingReservationService {
    @Autowired
    private ParkingReservationRepository parkingReservationRepository;

    @Override
    public ParkingReservation addParkingReservation(ParkingReservation parkingReservation) {
        parkingReservation.setStatus(ParkingReservation.Status.pending);
        return parkingReservationRepository.save(parkingReservation);
    }

    @Override
    public Optional<ParkingReservation> getParkingReservation(String id) {
        return parkingReservationRepository.findById(id);
    }

    @Override
    public List<ParkingReservation> getAllParkingReservations() {
        return parkingReservationRepository.findAll();
    }

    @Override
    public boolean deleteParkingReservation(String id) {
        if (parkingReservationRepository.existsById(id)) {
            parkingReservationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void confirmParkingReservation(String id) {
        Optional<ParkingReservation> existingReservation = parkingReservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            ParkingReservation reservation = existingReservation.get();

            // Set the status of the reservation to "accepted"
            reservation.setStatus(ParkingReservation.Status.accepted);

            // Save the updated reservation
            parkingReservationRepository.save(reservation);
        }
    }

    @Override
    public void declineParkingReservation(String id) {
        Optional<ParkingReservation> optionalReservation = parkingReservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            ParkingReservation reservation = optionalReservation.get();
            reservation.setStatus(ParkingReservation.Status.declined);
            parkingReservationRepository.save(reservation);
        }
    }


}