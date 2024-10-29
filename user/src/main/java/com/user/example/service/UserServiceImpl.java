package com.user.example.service;

import com.user.example.dto.ClientRequest;
import com.user.example.dto.ClientResponse;
import com.user.example.entity.Client;
import com.user.example.entity.User;
import com.user.example.repo.ClientRepository;
import com.user.example.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Override
    public ClientResponse register(ClientRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }

        Client client = new Client();
        client.setName(request.getName());
        client.setUsername(request.getUsername());
        client.setMail(request.getMail());
        client.setPhone(request.getPhone());

        clientRepository.save(client);

        User user = new User(request.getUsername(), request.getPassword(), request.getMail());
        userRepository.save(user);

        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setUsername(request.getUsername());
        clientResponse.setMessage("ONLINE");

        return clientResponse;
    }

    @Override
    public User getUserDetails(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
