package com.mechanic.workshop.dto.address;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record CreateAddressResponseDTO(
        UUID id,
        String street,
        String number,
        String zipCode,
        String district,
        UUID userId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
