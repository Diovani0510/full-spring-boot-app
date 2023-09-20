package com.example.springboot.dtos.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRecordDto(@NotBlank String name, @NotNull String password) {
}
