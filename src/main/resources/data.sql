DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS hotel;

CREATE TABLE hotel (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       location VARCHAR(255) NOT NULL,
                       rating DECIMAL(2,1) NOT NULL
);

CREATE TABLE room (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      hotel_id BIGINT NOT NULL,
                      number VARCHAR(50) NOT NULL,
                      type VARCHAR(50) NOT NULL,
                      price_per_night DECIMAL(10,2) NOT NULL,
                      FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE CASCADE
);

CREATE TABLE booking (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         room_id BIGINT NOT NULL,
                         guest_name VARCHAR(255) NOT NULL,
                         from_date DATE NOT NULL,
                         to_date DATE NOT NULL,
                         FOREIGN KEY (room_id) REFERENCES room(id) ON DELETE CASCADE
);
