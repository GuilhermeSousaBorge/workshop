package com.mechanic.workshop.service;

import com.mechanic.workshop.dto.user.CreateUserRequestDTO;
import com.mechanic.workshop.model.User;
import com.mechanic.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserRequestDTO requestDTO){

        var user = User.builder()
                .name(requestDTO.name())
                .phone(requestDTO.phone())
                .cpfCnpj(requestDTO.cpfCnpj())
                .role(requestDTO.role())
                .build();

        var newUser = this.userRepository.save(user);
        return newUser;
    }

}
