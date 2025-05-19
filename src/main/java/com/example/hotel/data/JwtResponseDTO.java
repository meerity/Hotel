package com.example.hotel.data;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponseDTO {
    private String token;
    private String type = "Bearer";
    private String username;
    private List<String> roles;

    public JwtResponseDTO() {}

    public JwtResponseDTO(String token, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }
}

