package tn.taha.ms_parking_management.controllers;




import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_parking_management.entities.ParkingSpace;
import tn.taha.ms_parking_management.services.ParkingSpaceServiceImp;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/parking-space")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ParkingSpaceController {
    @Autowired
    private ParkingSpaceServiceImp parkingSpaceService;

    @PostMapping()
    public ResponseEntity<ParkingSpace> add(@RequestBody ParkingSpace parkingSpace) {
        return new ResponseEntity<>(parkingSpaceService.addParkingSpace(parkingSpace), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParkingSpace> update(@Valid @RequestBody ParkingSpace parkingSpace, @PathVariable String id) {
        try {
            parkingSpace.setId(id);
            parkingSpaceService.addParkingSpace(parkingSpace);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ParkingSpace>> getAll() {
        return new ResponseEntity<>(parkingSpaceService.getAllParkingSpaces(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getParkingSpace(@PathVariable String id) {
        try {
            Optional<ParkingSpace> optionalParkingSpace = parkingSpaceService.getParkingSpace(id);

            if (optionalParkingSpace.isPresent()) {
                ParkingSpace parkingSpace = optionalParkingSpace.get();
                return new ResponseEntity<>(parkingSpace, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Parking Space not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return new ResponseEntity<>(parkingSpaceService.deleteParkingSpace(id), HttpStatus.OK);
    }
}