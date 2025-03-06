package com.mechanic.workshop.controller;

import com.mechanic.workshop.dto.UserRequestDto;
import com.mechanic.workshop.model.User;
import com.mechanic.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserRequestDto> createUser(@RequestBody User payload){

    }
}
