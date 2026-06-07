package com.fing.backend.infrastructure.persistence;

import com.fing.backend.domain.model.Borrower;
import com.fing.backend.domain.port.BorrowerRepository;
import com.fing.backend.infrastructure.persistence.entity.BorrowerEntity;
import com.fing.backend.infrastructure.persistence.jpa.SpringDataBorrowerJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresBorrowerRepository implements BorrowerRepository {

    private final SpringDataBorrowerJpaRepository jpaRepository;

    public PostgresBorrowerRepository(SpringDataBorrowerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Borrower save(Borrower borrower) {
        BorrowerEntity entity = toEntity(borrower);
        BorrowerEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Borrower> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    private BorrowerEntity toEntity(Borrower borrower) {
        return new BorrowerEntity(
                borrower.getId(),
                borrower.getFullName(),
                borrower.getPhoneNumber(),
                borrower.getCreatedAt()
        );
    }

    private Borrower toDomain(BorrowerEntity entity) {
        return new Borrower(
                entity.getId(),
                entity.getFullName(),
                entity.getPhoneNumber(),
                entity.getCreatedAt()
        );
    }
}
