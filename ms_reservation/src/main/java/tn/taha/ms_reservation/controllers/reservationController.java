package tn.taha.ms_reservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_reservation.entities.Reservation;
import tn.taha.ms_reservation.entities.enums.reservationStatus;
import tn.taha.ms_reservation.services.reservationServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reservation")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class reservationController {
    @Autowired
    private reservationServiceImpl serviceReservation;

    @PostMapping("/add/{idRoom}")
    public Reservation addReservation(@PathVariable int idRoom, @RequestBody Reservation reservation) {
        return serviceReservation.addReservation(idRoom,reservation);
    }
    @GetMapping("getByStatus/{status}")
    public List<Reservation> findByStatus(reservationStatus status) {
        return serviceReservation.findByStatus(status);
    }

    @GetMapping("/get/{id}")
    public Reservation getReservation(@PathVariable int id) {
        return serviceReservation.getReservation(id);
    }

    @PutMapping("/update/{id}")
    public Reservation update(@PathVariable int id,@RequestBody Reservation newReservation) {
        return serviceReservation.update(id, newReservation);
    }

    @GetMapping("/getAll")
    public List<Reservation> all_reservations() {
        return serviceReservation.all_reservations();
    }

    @DeleteMapping("/delete/{id}")
    public boolean DeleteReservation(@PathVariable int id) {
        return serviceReservation.DeleteReservation(id);
    }
}