package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("/company")
public class CompanyController {
    @GetMapping
    public String GetCompaniesByID (){
        return null;
    }

}
