package com.example.hotel.repo;

import com.example.hotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByGuestName(String guestName);
}
