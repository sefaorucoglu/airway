package Controller;

import entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirwayController {
    @GetMapping
    public String GetCompaniesByID() {
        return Company;
    }
}
