package com.example.demoserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String address;
    private String country;
    private String city;
}
