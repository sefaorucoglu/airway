package dto.request.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetCompanyInformationRequest {
    private String companyID;
}
