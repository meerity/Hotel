package com.example.hotel.service.impl;

import com.example.hotel.entity.Booking;
import com.example.hotel.repo.BookingRepository;
import com.example.hotel.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }

    @Override
    public Booking create(Booking b) {
        return repo.save(b);
    }

    @Override
    public List<Booking> findByGuest(String name) {
        return repo.findByGuestName(name);
    }
}
