package com.fing.backend.infrastructure.persistence.jpa;

import com.fing.backend.infrastructure.persistence.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataBorrowerJpaRepository extends JpaRepository<BorrowerEntity, UUID> {
}
