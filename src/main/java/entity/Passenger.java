package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Entity
public class Passenger {
    @Id
    private String IdentityNo;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String birthDate;
}
