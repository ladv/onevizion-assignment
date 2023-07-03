package com.onevizion.assignment.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Getter
public class ErrorResponse {
    private final String title;
    private final int status;
    private final Object detail;
    private final long timestamp;

    private ErrorResponse(String title, int status, Object detail) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public static ErrorResponse validationErrors(List<Violation> errors) {
        return new ErrorResponse("ValidationError", HttpStatus.BAD_REQUEST.value(), errors);
    }

    @Getter
    @RequiredArgsConstructor
    public static class Violation {
        private final String fieldName;
        private final String message;
    }
}
