package exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {
    String message;
}
