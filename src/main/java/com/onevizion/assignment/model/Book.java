package com.onevizion.assignment.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Book {
    private final Integer id;
    private final String title;
    private final String author;
    private final String description;
}


