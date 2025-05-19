package com.example.hotel.controller;

import com.example.hotel.entity.Hotel;
import com.example.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService svc;

    public HotelController(HotelService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Hotel> all() {
        return svc.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> one(@PathVariable Long id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel h) {
        return svc.create(h);
    }
}