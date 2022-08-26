package com.example.demoserver.service.user;

import com.example.demoserver.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User currentUser;

    public User getUser() {
        return currentUser;
    }

    public void createDummyUser() {
        currentUser = new User("John",
                "Martin",
                "john.martin@xygmailtest.com",
                "john1212",
                "123/Y, Darly Road, Colombo",
                "Sri Lanka",
                "Colombo");
    }
}
