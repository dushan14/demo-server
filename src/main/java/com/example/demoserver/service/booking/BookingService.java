package com.example.demoserver.service.booking;

import com.example.demoserver.dto.Booking;
import com.example.demoserver.dto.BookingItem;
import com.example.demoserver.dto.Item;
import com.example.demoserver.dto.User;
import com.example.demoserver.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    private final List<Item> items = new ArrayList<>();

    @Autowired
    UserService userService;

    public void initProducts() {
        items.addAll(Arrays.asList(
                new Item(101, "Redbull", 500, 0),
                new Item(104, "Milo", 90, 0),
                new Item(105, "CocaCola", 300, 50),
                new Item(109, "Leo Coffee", 1600, 0),
                new Item(118, "Hand Wash", 1600, 0),
                new Item(130, "GT Spice", 800, 0),
                new Item(120, "XY Chocolate", 2000, 0),
                new Item(141, "Hand Wash", 400, 0)
        ));
    }

    public Booking loadBooking() {
        return createDummyBookings(1).get(0);
    }

    public List<Booking> loadBookings() {
        return createDummyBookings(new Random().nextInt(6) + 1);
    }

    public List<Booking> createDummyBookings(int count) {
        User user = userService.getUser();

        ArrayList<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Booking booking = new Booking(1000 + i, user, new Date());
            List<BookingItem> dummyItems = createDummyItems();
            booking.setBookingItems(dummyItems);
            booking.updatePrices();
            bookings.add(booking);
        }
        return bookings;
    }

    public List<BookingItem> createDummyItems() {
        int itemsLength = this.items.size();
        Random random = new Random();
        int maxQt = 10;
        int minQt = 1;

        ArrayList<BookingItem> bookingItems = new ArrayList<>();
        for (int i = 0; i < itemsLength; i++) {
            int addOrNotCoin = random.nextInt(2);
            if (addOrNotCoin % 2 == 1) {
                continue;
            }

            Item item = this.items.get(i);
            int quantity = random.nextInt(maxQt - minQt + 1) + minQt;
            BookingItem bookingItem = new BookingItem(10000 + i,
                    item.getName(),
                    item.getPrice(),
                    quantity,
                    item.getPrice() * quantity,
                    item.getDiscount() * quantity);
            bookingItems.add(bookingItem);
        }

        if (bookingItems.size() == 0) {
            int quantity = random.nextInt(maxQt - minQt + 1) + minQt;
            int itemIndex = random.nextInt(itemsLength);
            Item item = this.items.get(itemIndex);
            BookingItem bookingItem = new BookingItem(10000 + itemIndex,
                    item.getName(),
                    item.getPrice(),
                    quantity,
                    item.getPrice() * quantity,
                    item.getDiscount() * quantity);
            bookingItems.add(bookingItem);
        }
        return bookingItems;
    }


}
