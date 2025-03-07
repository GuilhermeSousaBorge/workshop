package com.mechanic.workshop.dto.user;

import lombok.Builder;

@Builder
public record CreateUserRequestDTO(String name, String phone, String cpfCnpj, String role) {
}
