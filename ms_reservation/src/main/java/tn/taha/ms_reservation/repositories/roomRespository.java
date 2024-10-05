package tn.taha.ms_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.taha.ms_reservation.entities.Room;
import tn.taha.ms_reservation.entities.enums.roomType;

import java.util.List;

@Repository
public interface roomRespository extends JpaRepository<Room,Integer> {

    List<Room> findByHotel_IdHotel(int hotel);
    List<Room> findByHotel_idHotelAndAndType(int hotel, roomType type );

}