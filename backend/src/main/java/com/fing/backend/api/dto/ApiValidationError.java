package com.fing.backend.api.dto;

public record ApiValidationError(
        String field,
        String message
) {
}