package com.example.hotel.service;

import com.example.hotel.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> findAll();

    Optional<Hotel> findById(Long id);
}
