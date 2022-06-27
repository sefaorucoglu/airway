package controller;

import dto.request.booking.AddBookingRequest;
import dto.response.booking.BookingResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

@RequestScope
@RestController
@RequestMapping("/bookings")
@Validated
public class BookingController {
    private final service.BookingService BookingService;

    public BookingController(service.BookingService bookingService) {
        this.BookingService = bookingService;
    }

    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BookingResponse> createBooking (@RequestBody @Valid AddBookingRequest request) {
        return BookingService.createBooking(request);
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public Optional<BookingResponse> deleteBookingById (@PathVariable String BookingId){
        return BookingService.removeBookingById(BookingId);
    }













}
