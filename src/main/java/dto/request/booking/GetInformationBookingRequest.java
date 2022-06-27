package dto.request.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
public class GetInformationBookingRequest {
    private String BookingId;
    private String IdentityNo;
}
