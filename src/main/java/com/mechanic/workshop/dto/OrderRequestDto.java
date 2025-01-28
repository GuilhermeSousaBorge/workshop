package com.mechanic.workshop.dto;

import com.mechanic.workshop.model.Part;
import com.mechanic.workshop.model.User;

public record OrderRequestDto(
        String description, double workforce, Part part, int partAmount, User user, boolean status) {
}
