package com.example.demoserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking {
    private long id;
    private User user;
    private List<BookingItem> bookingItems;
    private double totalPrice;
    private double discount;
    private double finalPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loadedTime;

    public Booking(long id, User user, Date loadedTime) {
        this.id = id;
        this.user = user;
        this.loadedTime = loadedTime;
    }

    public void updatePrices() {
        totalPrice = 0;
        discount = 0;
        if (bookingItems != null) {
            for (BookingItem item : bookingItems) {
                totalPrice += item.getPrice();
                discount += item.getDiscount();
            }
        }
        finalPrice = totalPrice - discount;
    }
}
