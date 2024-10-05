package tn.taha.ms_reservation.services.interfaces;

import tn.taha.ms_reservation.entities.Hotel;

import java.util.List;

public interface hotelService {
    public Hotel addHotel(Hotel hotel);

    public Hotel getHotel (int id);
    List<Hotel> getHotelsByCountry(String country);

    public Hotel update(int id, Hotel newhotel);

    public List<Hotel> all_hotels();

    public boolean DeleteHotel(int id);
}
