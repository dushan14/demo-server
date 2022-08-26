package com.example.demoserver.controller.user;

import com.example.demoserver.dto.User;
import com.example.demoserver.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public User getBookings() {
        return userService.getUser();
    }
}
