package tn.taha.ms_reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.taha.ms_reservation.entities.Hotel;
import tn.taha.ms_reservation.entities.Room;
import tn.taha.ms_reservation.entities.enums.roomType;
import tn.taha.ms_reservation.repositories.hotelRepository;
import tn.taha.ms_reservation.repositories.roomRespository;
import tn.taha.ms_reservation.services.interfaces.roomService;

import java.util.List;
@Service
public class roomServiceImpl implements roomService {

    @Autowired
    roomRespository roomRepo;
    @Autowired
    hotelRepository hotelRepo;

    @Override
    public Room addRoom(int idHotel, Room room) {
        if (hotelRepo.findById(idHotel).isPresent()) {
            Hotel hotel= hotelRepo.findById(idHotel).get();
            room.setHotel(hotel);

            return roomRepo.save(room);

        }else {
            return null;
        }

    }


    @Override
    public Room getRoom(int id) {
        if (roomRepo.findById(id).isPresent()) {
            Room roomm = roomRepo.findById(id).get();
            return roomm;
        }else {
            return null;
        }      }

    @Override
    public Room update(int id, Room newRoom) {
        if (roomRepo.findById(id).isPresent()) {
            Room roomm = roomRepo.findById(id).get();
            roomm.setDescription(roomm.getDescription());
            roomm.setEtage(roomm.getEtage());
            roomm.setCapacitePersonne(roomm.getCapacitePersonne());
            roomm.setNumero(roomm.getNumero());
            roomm.setPrixNuitee(roomm.getPrixNuitee());
            roomm.setDisponibilite(roomm.getDisponibilite());
            return roomRepo.save(roomm);
        }else {
            return null;
        }       }

    @Override
    public List<Room> findByHotel_idHotel(int hotel) {
        return roomRepo.findByHotel_IdHotel(hotel);
    }

    @Override
    public List<Room> findByHotel_idHotelAndAndType(int hotel, roomType type) {
        return roomRepo.findByHotel_idHotelAndAndType(hotel,type);
    }

    @Override
    public List<Room> all_Rooms() {

        return roomRepo.findAll();
    }

    @Override
    public boolean DeleteRoom(int id) {

        if (roomRepo.findById(id).isPresent()) {
            roomRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
