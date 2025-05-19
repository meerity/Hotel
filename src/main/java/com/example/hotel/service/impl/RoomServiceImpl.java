package com.example.hotel.service.impl;


import com.example.hotel.entity.Room;
import com.example.hotel.repo.RoomRepository;
import com.example.hotel.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repo;

    public RoomServiceImpl(RoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public Room create(Room r) {
        return repo.save(r);
    }

    @Override
    public List<Room> findByHotel(Long hotelId) {
        return repo.findByHotelId(hotelId);
    }

    @Override
    public List<Room> findAll() {
        return repo.findAll();
    }
}
