package com.onevizion.assignment.model;

import jakarta.validation.constraints.NotBlank;

public record NewBook(
        @NotBlank String title,
        @NotBlank String author,
        String description
) {
}
