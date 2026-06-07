package com.fing.backend.domain.model;

import java.time.Instant;
import java.util.UUID;

public class Borrower {

    private UUID id;
    private String fullName;
    private String phoneNumber;
    private Instant createdAt;

    public Borrower(UUID id, String fullName, String phoneNumber, Instant createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
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
