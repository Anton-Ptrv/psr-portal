package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    Optional<Classification> findClassificationById(long id);

}
