package com.mechanic.workshop.dto.address;

import com.mechanic.workshop.model.User;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateAddressRequestDTO(String street, String number, String zipCode, String district, UUID userId) {
}
