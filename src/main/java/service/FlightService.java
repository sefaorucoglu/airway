package service;

import dto.request.flight.GetFlightInformationRequest;
import dto.request.flight.UpdateFlightRequest;
import dto.request.flight.AddFlightRequest;
import dto.response.flight.FlightResponse;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Optional<FlightResponse> createFlight (AddFlightRequest request);
    Optional<FlightResponse> removeFlightById (String id);
    Optional<FlightResponse> updateFlight (UpdateFlightRequest request);
    List<FlightResponse> findAll (int PageNo, int PageSize);
    List<FlightResponse> findFlights (GetFlightInformationRequest request);
}
