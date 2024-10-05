package tn.taha.ms_reservation.services.interfaces;

import tn.taha.ms_reservation.entities.Room;
import tn.taha.ms_reservation.entities.enums.roomType;

import java.util.List;

public interface roomService {

    public Room addRoom(int idHotel, Room room);

    public Room getRoom (int id);

    public Room update(int id, Room newRoom);
    List<Room> findByHotel_idHotel(int hotel);
    List<Room> findByHotel_idHotelAndAndType(int hotel, roomType type);
    public List<Room> all_Rooms();

    public boolean DeleteRoom(int id);
}
