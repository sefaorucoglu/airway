package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bookings")
public class Booking {
    @Id
    private String bookingID;
    private String flightNumber;
    private String bookingDate;
    private String bookingStatus;
    private String identityNo;


}
