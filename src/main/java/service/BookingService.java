package service;

import dto.request.booking.GetInformationBookingRequest;
import dto.request.booking.UpdateBookingRequest;
import dto.request.booking.AddBookingRequest;
import dto.response.booking.BookingResponse;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Optional<BookingResponse> createBooking(AddBookingRequest request);
    Optional<BookingResponse> removeBookingById(String id);
    Optional<BookingResponse> updateBooking(UpdateBookingRequest updateRequest);
    List<BookingResponse> findCompany(GetInformationBookingRequest request);
    List<BookingResponse> findAll (int pageNo, int pageSize);
}
