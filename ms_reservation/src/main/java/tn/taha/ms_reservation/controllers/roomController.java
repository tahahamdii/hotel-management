package tn.taha.ms_reservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_reservation.entities.Room;
import tn.taha.ms_reservation.entities.enums.roomType;
import tn.taha.ms_reservation.services.roomServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/room")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class roomController {

    @Autowired
    private roomServiceImpl roomService;

    @PostMapping("/add/{idHotel}")
    public Room addRoom(@PathVariable int idHotel, @RequestBody Room room) {
        return roomService.addRoom(idHotel,room);
    }
    @GetMapping("/getByHotel/{hotel}")
    public List<Room> findByHotel(@PathVariable int hotel) {
        return roomService.findByHotel_idHotel(hotel);
    }
    @GetMapping("fingByType/{hotel}/{type}")
    public List<Room> findByHotel_idHotelAndAndType(@PathVariable int hotel,@PathVariable roomType type) {
        return roomService.findByHotel_idHotelAndAndType(hotel, type);
    }

    @GetMapping("/getById/{id}")
    public Room getRoom(@PathVariable int id) {
        return roomService.getRoom(id);
    }

    @PutMapping("/update/{id}")
    public Room update(@PathVariable int id, @RequestBody Room newRoom) {
        return roomService.update(id, newRoom);
    }

    @GetMapping("/getAll")
    public List<Room> all_Rooms() {
        return roomService.all_Rooms();
    }
    @DeleteMapping("/delete/{id}")
    public boolean DeleteRoom(@PathVariable int id) {
        return roomService.DeleteRoom(id);
    }
}
