package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    private String flightNumber;
    private String from;
    private String to;
    private String flightDate;
    
    private String boardingTime;
    @Enumerated(EnumType.ORDINAL)
    private Status Status;
    @ManyToOne
    @JoinColumn(name = "identity_no_flight_number")
    private Passenger identityNo;




}
