package com.example.hotel.service;

import com.example.hotel.entity.Room;

import java.util.List;

public interface RoomService {
    Room create(Room room);

    List<Room> findByHotel(Long hotelId);

    List<Room> findAll();
}
