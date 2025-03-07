package com.mechanic.workshop.service;

import com.mechanic.workshop.dto.address.CreateAddressRequestDTO;
import com.mechanic.workshop.dto.address.CreateAddressResponseDTO;
import com.mechanic.workshop.model.Address;
import com.mechanic.workshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public CreateAddressResponseDTO createAddress(CreateAddressRequestDTO requestDTO){

        var address = Address.builder()
                .street(requestDTO.street())
                .number(requestDTO.number())
                .zipCode(requestDTO.zipCode())
                .district(requestDTO.district())
                .userId(requestDTO.userId())
                .build();

        var newAddress = this.addressRepository.save(address);

        var response = CreateAddressResponseDTO.builder()
                .id(newAddress.getId())
                .street(newAddress.getStreet())
                .number(newAddress.getNumber())
                .zipCode(newAddress.getZipCode())
                .district(newAddress.getDistrict())
                .userId(newAddress.getUserId())
                .createdAt(newAddress.getCreatedAt())
                .updatedAt(newAddress.getUpdatedAt())
                .build();

        return response;
    }
}
