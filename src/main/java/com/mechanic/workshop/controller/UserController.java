package com.mechanic.workshop.controller;

import com.mechanic.workshop.dto.address.CreateAddressRequestDTO;
import com.mechanic.workshop.dto.user.CreateUserRequestDTO;
import com.mechanic.workshop.service.AddressService;
import com.mechanic.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequestDTO requestDTO){
        try{
            var user = this.userService.createUser(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/address")
    public ResponseEntity<Object> createAddress(@RequestBody CreateAddressRequestDTO requestDTO){
        try{
            var address = this.addressService.createAddress(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(address);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
