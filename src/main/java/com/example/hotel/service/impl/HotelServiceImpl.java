package com.example.hotel.service.impl;

import com.example.hotel.entity.Hotel;
import com.example.hotel.repo.HotelRepository;
import com.example.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repo;

    public HotelServiceImpl(HotelRepository repo) {
        this.repo = repo;
    }

    @Override
    public Hotel create(Hotel h) {
        return repo.save(h);
    }

    @Override
    public List<Hotel> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return repo.findById(id);
    }
}
