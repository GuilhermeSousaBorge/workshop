package com.mechanic.workshop.dto;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponseDto(
        long id,
        String name,
        String email,
        String password,
        String phone,
        String cpfCnpj,
        List<Order> order,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
