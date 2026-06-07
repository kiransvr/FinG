package com.fing.backend.domain.port;

import com.fing.backend.domain.model.Borrower;

import java.util.Optional;
import java.util.UUID;

public interface BorrowerRepository {

    Borrower save(Borrower borrower);

    Optional<Borrower> findById(UUID id);
}
