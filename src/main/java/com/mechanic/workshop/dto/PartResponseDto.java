package com.mechanic.workshop.dto;

import java.time.LocalDateTime;

public record PartResponseDto(
        long id,
        String partName,
        String vehicleBrand,
        String vehicleModel,
        int vehicleYear,
        double unityPrice,
        long quantity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
