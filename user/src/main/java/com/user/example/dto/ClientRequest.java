package com.user.example.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequest {

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    private String username;
    private String mail;
    private String phone;
    private String password;
}
