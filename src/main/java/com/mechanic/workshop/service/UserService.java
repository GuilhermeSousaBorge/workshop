package com.mechanic.workshop.service;

import com.mechanic.workshop.dto.UserRequestDto;
import com.mechanic.workshop.dto.UserResponseDto;
import com.mechanic.workshop.exception.BadRequestException;
import com.mechanic.workshop.model.User;
import com.mechanic.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDto payload){
        User newUser = new User(payload);

        this.userRepository.save(newUser);
        return newUser;
    }

    public User listUser(long id){
        return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException("Usuario nao encontrado"));
    }

    public List<User> listUser(){
        return this.userRepository.findAll().stream().toList();
    }
}
