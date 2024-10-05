package tn.taha.ms_reservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_reservation.entities.Hotel;
import tn.taha.ms_reservation.services.hotelServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hotel")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class hotelController {

    @Autowired
    private hotelServiceImpl hotelService;

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/getById/{id}")
    public Hotel getHotel(@PathVariable int id) {
        return hotelService.getHotel(id);
    }

    @PutMapping("/update/{id}")
    public Hotel update(@PathVariable int id, @RequestBody Hotel newhotel) {
        return hotelService.update(id, newhotel);
    }

    @GetMapping("/getAll")
    public List<Hotel> all_hotels() {
        return hotelService.all_hotels();
    }

    @DeleteMapping("/delete/{id}")
    public boolean DeleteHotel(@PathVariable int id) {
        return hotelService.DeleteHotel(id);
    }

    @GetMapping("/getByCountry/{country}")
    public List<Hotel> getHotelsByCountry(@PathVariable String country) {
        return hotelService.getHotelsByCountry(country);
    }
}
