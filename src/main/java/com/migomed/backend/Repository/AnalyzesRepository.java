package com.migomed.backend.Repository;

import com.migomed.backend.Entity.Analyzes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzesRepository extends JpaRepository<Analyzes, Long> {
}
