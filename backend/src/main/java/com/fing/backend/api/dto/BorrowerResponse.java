package com.fing.backend.api.dto;

import com.fing.backend.domain.model.Borrower;

import java.time.Instant;
import java.util.UUID;

public class BorrowerResponse {

    private UUID id;
    private String fullName;
    private String phoneNumber;
    private Instant createdAt;

    public static BorrowerResponse fromDomain(Borrower borrower) {
        BorrowerResponse response = new BorrowerResponse();
        response.id = borrower.getId();
        response.fullName = borrower.getFullName();
        response.phoneNumber = borrower.getPhoneNumber();
        response.createdAt = borrower.getCreatedAt();
        return response;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
