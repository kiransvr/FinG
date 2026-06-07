package com.fing.backend.api.controller;

import com.fing.backend.api.dto.BorrowerResponse;
import com.fing.backend.api.dto.CreateBorrowerRequest;
import com.fing.backend.application.service.BorrowerService;
import com.fing.backend.domain.model.Borrower;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BorrowerResponse create(@Valid @RequestBody CreateBorrowerRequest request) {
        Borrower borrower = borrowerService.createBorrower(request.getFullName(), request.getPhoneNumber());
        return BorrowerResponse.fromDomain(borrower);
    }

    @GetMapping("/{borrowerId}")
    public BorrowerResponse getById(@PathVariable UUID borrowerId) {
        Borrower borrower = borrowerService.getBorrower(borrowerId);
        return BorrowerResponse.fromDomain(borrower);
    }
}
