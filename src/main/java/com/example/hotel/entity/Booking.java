package com.example.hotel.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;
    private LocalDate fromDate;
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Booking() {}

    public Booking(Long id, String guestName, LocalDate fromDate, LocalDate toDate, Room room) {
        this.id = id;
        this.guestName = guestName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
