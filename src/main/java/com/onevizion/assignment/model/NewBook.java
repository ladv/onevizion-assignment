package com.onevizion.assignment.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewBook {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private String description;
}
