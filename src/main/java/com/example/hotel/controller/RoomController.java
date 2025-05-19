package com.example.hotel.controller;

import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService svc;

    public RoomController(RoomService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Room> all() {
        return svc.findAll();
    }

    @GetMapping("/by-hotel/{hotelId}")
    public List<Room> byHotel(@PathVariable Long hotelId) {
        return svc.findByHotel(hotelId);
    }

    @PostMapping
    public Room create(@RequestBody Room r) {
        return svc.create(r);
    }
}