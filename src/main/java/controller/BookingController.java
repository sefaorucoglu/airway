package controller;

import dto.request.booking.AddBookingRequest;
import dto.request.booking.GetInformationBookingRequest;
import dto.request.booking.UpdateBookingRequest;
import dto.response.booking.BookingResponse;
import exception.BookingNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import service.BookingService;

import java.util.List;
import java.util.Optional;

@RequestScope
@RestController
@RequestMapping("/bookings")
@Validated
public class BookingController {
    private final service.BookingService bookingService;

    public BookingController(service.BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BookingResponse> createBooking (@RequestBody @Valid AddBookingRequest request) {
        return bookingService.createBooking(request);
    }
    @DeleteMapping(value = "/delete/{BookingId}")
    public Optional<BookingResponse> deleteBookingById (@PathVariable String BookingId){
        return bookingService.removeBookingById(BookingId);
    }
    @PutMapping(value="/update")
    public Optional<BookingResponse> updateBooking (@RequestBody @Valid UpdateBookingRequest updateBookingRequest){
        return bookingService.updateBooking(updateBookingRequest);
    }
    @PostMapping("/getBooking")
    public List<BookingResponse> findBooking (GetInformationBookingRequest request) {
        if (request.getIdentityNo().equals("")&&request.getBookingId().equals("")){
            throw new BookingNotFoundException("Inputs could not be empty.");
        }
        return bookingService.findBooking(request);
    }
    @GetMapping
    public List<BookingResponse> findAllBookings (@RequestParam(defaultValue = "0",required = false) int pageNo,@RequestParam(defaultValue = "20",required = false) int pageSize){
        return bookingService.findAll(pageNo,pageSize);
    }
    @ExceptionHandler(value = BookingNotFoundException.class)
    public ResponseEntity<Object> exception (BookingNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
