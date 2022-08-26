package com.example.demoserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private long id;
    private String name;
    private double price;
    private double discount;
}
