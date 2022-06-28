package service.business;

import dto.request.booking.AddBookingRequest;
import dto.request.booking.GetInformationBookingRequest;
import dto.request.booking.UpdateBookingRequest;
import dto.response.booking.BookingResponse;
import exception.BookingNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BookingRepository;
import service.BookingService;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
@Service
public class BookingImp implements BookingService {
    private static final Supplier<BookingNotFoundException> bookingNotFoundExceptionSupplier =
            () -> new BookingNotFoundException("Booking Not Found!");
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    public BookingImp(ModelMapper modelMapper, BookingRepository bookingRepository) {
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Optional<BookingResponse> createBooking(AddBookingRequest request) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<BookingResponse> removeBookingById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<BookingResponse> updateBooking(UpdateBookingRequest updateRequest) {
        return Optional.empty();
    }

    @Override
    public List<BookingResponse> findBooking(GetInformationBookingRequest request) {
        return null;
    }

    @Override
    public List<BookingResponse> findAll(int pageNo, int pageSize) {
        return null;
    }
}
