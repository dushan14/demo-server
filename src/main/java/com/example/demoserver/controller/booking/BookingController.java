package com.example.demoserver.controller.booking;

import com.example.demoserver.dto.Booking;
import com.example.demoserver.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "recent")
    public List<Booking> getBookings() {
        return bookingService.loadBookings();
    }

    @GetMapping(value = "current")
    public Booking getBooking() {
        return bookingService.loadBooking();
    }
}
