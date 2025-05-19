package com.example.hotel.controller;

import com.example.hotel.entity.Booking;
import com.example.hotel.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService svc;

    public BookingController(BookingService svc) {
        this.svc = svc;
    }

    @PostMapping
    public Booking create(@RequestBody Booking b) {
        return svc.create(b);
    }

    @GetMapping("/by-guest")
    public ResponseEntity<List<Booking>> byGuest(@RequestParam String guestName) {
        if (guestName.isBlank()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(svc.findByGuest(guestName));
    }
}