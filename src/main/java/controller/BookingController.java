package controller;

import dto.request.booking.AddBookingRequest;
import dto.response.booking.BookingResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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













}
