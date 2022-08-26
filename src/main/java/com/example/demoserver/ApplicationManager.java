package com.example.demoserver;

import com.example.demoserver.service.booking.BookingService;
import com.example.demoserver.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationManager {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        userService.createDummyUser();
        bookingService.initProducts();
    }
}
