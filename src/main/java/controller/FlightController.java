package controller;

import dto.request.flight.AddFlightRequest;
import dto.request.flight.GetFlightInformationRequest;
import dto.request.flight.UpdateFlightRequest;
import dto.response.flight.FlightResponse;
import exception.FlightNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import service.FlightService;

import java.util.List;
import java.util.Optional;
@RequestScope
@RestController
@RequestMapping("/flights")
@Validated
public class FlightController {
    private final service.FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }


    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<FlightResponse> createFlight (@RequestBody @Valid AddFlightRequest request) {
        return flightService.createFlight(request);
    }
    @DeleteMapping(value = "/delete/{FlightId}")
    public Optional<FlightResponse> deleteFlightById (@PathVariable String FlightId){
        return flightService.removeFlightById(FlightId);
    }
    @PutMapping(value="/update")
    public Optional<FlightResponse> updateFlight (@RequestBody @Valid UpdateFlightRequest updateFlightRequest){
        return flightService.updateFlight(updateFlightRequest);
    }
    @PostMapping("/getFlight")
    public List<FlightResponse> findFlight(@RequestBody GetFlightInformationRequest request) {
        if (request.getFlightDate().equals("")&&request.getFlightNumber().equals("")&&request.getFlightDate().equals("")&&
        request.getFrom().equals("")&&request.getTo().equals("")&&request.getStatus().equals("")
        ){
            throw new FlightNotFoundException("Inputs could not be empty.");
        }
        return flightService.findFlight(request);
    }
    @GetMapping
    public List<FlightResponse> findAllFlights (@RequestParam(defaultValue = "0",required = false) int pageNo,@RequestParam(defaultValue = "20",required = false) int pageSize){
        return flightService.findAll(pageNo,pageSize);
    }
    @ExceptionHandler(value = FlightNotFoundException.class)
    public ResponseEntity<Object> exception (FlightNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
