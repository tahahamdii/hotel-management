package tn.taha.ms_parking_management.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Document(collection = "parkingReservations")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingReservation {

    @Id

    private String id;

    // private Date reservationDate;
    private String guestName;
    private String vehicleImmatricule;
    private Date arrivalDate;
    private Date departureDate;
    private Status status;


    private Object owner;

    @DBRef
    private ParkingSpace parkingSpace;

    public enum Status {
        accepted,
        declined,
        pending
    }
}