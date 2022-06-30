package dto.request.booking;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import validation.ValidDate;

@Data
@Builder
@AllArgsConstructor
public class AddBookingRequest {
    @NotBlank
    private String bookingID;
    @NotBlank
    private String flightNumber;
    @NotBlank
    @ValidDate
    private String bookingDate;


}
