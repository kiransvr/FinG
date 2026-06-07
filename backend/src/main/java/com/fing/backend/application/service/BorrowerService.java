package com.fing.backend.application.service;

import com.fing.backend.domain.model.Borrower;
import com.fing.backend.domain.port.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public Borrower createBorrower(String fullName, String phoneNumber) {
        Borrower borrower = new Borrower(UUID.randomUUID(), fullName, phoneNumber, Instant.now());
        return borrowerRepository.save(borrower);
    }

    public Borrower getBorrower(UUID borrowerId) {
        return borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new IllegalArgumentException("Borrower not found: " + borrowerId));
    }
}
