package com.mechanic.workshop.dto;

public record UserRequestDto(String name, String email, String password, String phone, String cpfCnpj) {
}
