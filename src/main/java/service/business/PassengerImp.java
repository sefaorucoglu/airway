package service.business;

import dto.request.passenger.AddPassengerRequest;
import dto.request.passenger.GetInformationPassengerRequest;
import dto.request.passenger.UpdatePassengerRequest;
import dto.response.passenger.PassengerResponse;
import exception.PassengerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import repository.BookingRepository;
import service.PassengerService;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class PassengerImp implements PassengerService {
    private static final Supplier<PassengerNotFoundException> passengerNotFoundExceptionSupplier =
            () -> new PassengerNotFoundException("Company Not Found!");
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    public PassengerImp(ModelMapper modelMapper, BookingRepository bookingRepository) {
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Optional<PassengerResponse> createPassenger(AddPassengerRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<PassengerResponse> removePassengerById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<PassengerResponse> updatePassenger(UpdatePassengerRequest updateRequest) {
        return Optional.empty();
    }

    @Override
    public List<PassengerResponse> findPassenger(GetInformationPassengerRequest request) {
        return null;
    }

    @Override
    public List<PassengerResponse> findAll(int pageNo, int pageSize) {
        return null;
    }
}
