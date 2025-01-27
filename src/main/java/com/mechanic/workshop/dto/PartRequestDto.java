package com.mechanic.workshop.dto;

public record PartRequestDto(
        String partName,
        String vehicleBrand,
        String vehicleModel,
        int vehicleYear,
        double unityPrice,
        long quantity) {
}
