package tn.taha.ms_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.taha.ms_reservation.entities.Hotel;

import java.util.List;

@Repository
public interface hotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByCountry(String country);

}