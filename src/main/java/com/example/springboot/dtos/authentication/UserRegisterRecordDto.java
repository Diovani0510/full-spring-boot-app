package com.example.springboot.dtos.authentication;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterRecordDto(@NotBlank String name, @NotBlank String email, @NotBlank String password, @NotBlank String role) {
}
