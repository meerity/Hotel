package com.example.hotel.data;

import lombok.Data;

@Data
public class UserDataRequestDTO {

    private String username;
    private String password;

    public UserDataRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
