package tn.taha.ms_parking_management.entities;

import lombok.*;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "parkingSpaces")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpace {

    @Id

    private String id;
    private String spaceNumber;
    private Type type;
    private String location;
    private Status status;

    @DBRef
    List<ParkingReservation> parkingreservations;

    public enum Type {
        Standard,
        Valet
    }

    public enum Status {
        Available,
        NotAvailable
    }


}