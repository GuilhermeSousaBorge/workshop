package com.mechanic.workshop.dto;

import com.mechanic.workshop.model.Part;
import com.mechanic.workshop.model.User;

import java.time.LocalDateTime;

public record OrderResponseDto(
        long id,
        String description,
        double workforce,
        Part part,
        int partAmount,
        User user,
        boolean status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
