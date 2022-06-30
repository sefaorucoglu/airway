package service.business;

import dto.request.flight.AddFlightRequest;
import dto.request.flight.GetFlightInformationRequest;
import dto.request.flight.UpdateFlightRequest;
import dto.response.flight.FlightResponse;
import exception.FlightNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import repository.BookingRepository;
import service.FlightService;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class FlightImp implements FlightService {
    private static final Supplier<FlightNotFoundException> flightNotFoundExceptionSupplier =
            () -> new FlightNotFoundException("Company Not Found!");
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    public FlightImp(ModelMapper modelMapper, BookingRepository bookingRepository) {
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Optional<FlightResponse> createFlight(AddFlightRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<FlightResponse> removeFlightById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<FlightResponse> updateFlight(UpdateFlightRequest request) {
        return Optional.empty();
    }

    @Override
    public List<FlightResponse> findAll(int PageNo, int PageSize) {
        return null;
    }

    @Override
    public List<FlightResponse> findFlight(GetFlightInformationRequest request) {
        return null;
    }
}
