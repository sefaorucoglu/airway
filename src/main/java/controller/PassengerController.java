package controller;

import dto.request.passenger.AddPassengerRequest;
import dto.request.passenger.GetInformationPassengerRequest;
import dto.request.passenger.UpdatePassengerRequest;
import dto.response.passenger.PassengerResponse;
import exception.PassengerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import service.PassengerService;


import java.util.List;
import java.util.Optional;

@RequestScope
@RestController
@RequestMapping("/passengers")
@Validated
@CrossOrigin
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<PassengerResponse> createPassenger(@RequestBody @Valid AddPassengerRequest request) {
        return passengerService.createPassenger(request);
    }

    @DeleteMapping("/delete/{IdentityNo}")
    public Optional<PassengerResponse> removePassengerById(@PathVariable String IdentityNo) {
        return passengerService.removePassengerById(IdentityNo);
    }

    @PutMapping(value = "/update")
    public Optional<PassengerResponse> updatePassenger(@Valid @RequestBody UpdatePassengerRequest updateRequest){
        return passengerService.updatePassenger(updateRequest);
    }

    @PostMapping("/getCustomers")
    public List<PassengerResponse> findPassenger(@RequestBody GetInformationPassengerRequest request){
        if (request.getEmail().equals("")&&request.getIdentityNo().equals("")){
            throw new PassengerNotFoundException("Input could not be empty.");
        }
        return passengerService.findPassenger(request);
    }

    @GetMapping
    public List<PassengerResponse> findAll(@RequestParam(defaultValue = "0", required = false) int pageNo, @RequestParam(defaultValue = "20",required = false) int pageSize){
        return passengerService.findAll(pageNo, pageSize);
    }

    @ExceptionHandler(value = PassengerNotFoundException.class)
    public ResponseEntity<Object> exception (PassengerNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
