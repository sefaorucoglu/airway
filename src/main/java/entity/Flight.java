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
    private String landingTime;
    @Enumerated(EnumType.ORDINAL)
    private String Status;




}
