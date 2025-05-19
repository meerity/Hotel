package com.example.hotel.service;

import com.example.hotel.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking create(Booking booking);

    List<Booking> findByGuest(String guestName);
}
