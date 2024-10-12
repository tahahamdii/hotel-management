package tn.taha.ms_parking_management.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.taha.ms_parking_management.entities.ParkingReservation;


@Repository
public interface ParkingReservationRepository extends MongoRepository<ParkingReservation, String> {

}