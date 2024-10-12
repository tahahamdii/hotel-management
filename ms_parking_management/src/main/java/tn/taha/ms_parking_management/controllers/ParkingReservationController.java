package tn.taha.ms_parking_management.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_parking_management.entities.ParkingReservation;
import tn.taha.ms_parking_management.services.interfaces.ParkingReservationService;
import tn.taha.ms_parking_management.services.interfaces.ParkingSpaceService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/parking-reservation")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ParkingReservationController {

    @Autowired
    private ParkingReservationService parkingReservationService;

    @Autowired
    private ParkingSpaceService parkingSpaceService;


    @PostMapping()
    public ResponseEntity<ParkingReservation> add(@RequestBody ParkingReservation parkingReservation) {
        return new ResponseEntity<>(parkingReservationService.addParkingReservation(parkingReservation), HttpStatus.OK);
    }




    @PutMapping(value = "/{id}")
    public ResponseEntity<ParkingReservation> update(@Valid @RequestBody ParkingReservation parkingReservation, @PathVariable String id) {
        try {
            parkingReservation.setId(id);
            parkingReservationService.addParkingReservation(parkingReservation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ParkingReservation>> getAll() {
        return new ResponseEntity<>(parkingReservationService.getAllParkingReservations(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getParkingReservation(@PathVariable String id) {
        try {
            Optional<ParkingReservation> optionalParkingReservation = parkingReservationService.getParkingReservation(id);

            if (optionalParkingReservation.isPresent()) {
                ParkingReservation parkingReservation = optionalParkingReservation.get();
                return new ResponseEntity<>(parkingReservation, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Parking Reservation not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return new ResponseEntity<>(parkingReservationService.deleteParkingReservation(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/confirm")
    public ResponseEntity<?> confirm(@PathVariable String id) {
        try {
            parkingReservationService.confirmParkingReservation(id);
            return new ResponseEntity<>("Parking Reservation confirmed", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Parking Reservation not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}/decline")
    public ResponseEntity<?> declineParkingReservation(@PathVariable String id) {
        try {
            parkingReservationService.declineParkingReservation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}