package com.example.demoserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingItem {
    private long id;
    private String name;
    private double unitPrice;
    private int quantity;
    private double price;
    private double discount;
}
