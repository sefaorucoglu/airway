package controller;

import dto.request.company.AddCompanyRequest;
import dto.request.company.GetCompanyInformationRequest;
import dto.request.company.UpdateCompanyRequest;
import dto.request.flight.GetFlightInformationRequest;
import dto.request.flight.UpdateFlightRequest;
import dto.response.company.CompanyResponse;
import exception.CompanyNotFoundException;
import exception.FlightNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import service.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestScope
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<CompanyResponse> createCompany (@RequestBody @Valid AddCompanyRequest request) {
        return companyService.createCompany(request);
    }
    @DeleteMapping(value = "/delete/{CompanyId}")
    public Optional<CompanyResponse> deleteCompanyById (@PathVariable String CompanyId){
        return companyService.removeCompanyById(CompanyId);
    }
    @PutMapping(value="/update")
    public Optional<CompanyResponse> updateCompany (@RequestBody @Valid UpdateCompanyRequest updateCompanyRequest){
        return companyService.updateCompany(updateCompanyRequest);
    }
    @PostMapping("/getCompany")
    public List<CompanyResponse> findCompany (@RequestBody GetCompanyInformationRequest request) {
        if (request.getCompanyID().equals("")
        ){
            throw new FlightNotFoundException("Inputs could not be empty.");
        }
        return companyService.findCompany(request);
    }
    @GetMapping
    public List<CompanyResponse> findAllCompanies (@RequestParam(defaultValue = "0",required = false) int pageNo, @RequestParam(defaultValue = "20",required = false) int pageSize){
        return companyService.findAll(pageNo,pageSize);
    }
    @ExceptionHandler(value = CompanyNotFoundException.class)
    public ResponseEntity<Object> exception (FlightNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
