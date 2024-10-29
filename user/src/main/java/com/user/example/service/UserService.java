package com.user.example.service;


import com.user.example.dto.ClientRequest;
import com.user.example.dto.ClientResponse;
import com.user.example.entity.User;



public interface UserService {

     ClientResponse register(ClientRequest request);
     User getUserDetails(Long userId);
}
//public static final String URL = "jdbc:postgresql://localhost:5434/library";
//public static final String USER = "postgres";
//public static final String PASSWORD = "shola123";