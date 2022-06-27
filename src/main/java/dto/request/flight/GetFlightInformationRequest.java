package dto.request.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class GetFlightInformationRequest {
    private String flightNumber;
    private String from;
    private String to;
    private String flightDate;
    private Enum status;
}
