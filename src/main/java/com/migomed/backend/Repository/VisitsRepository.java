package com.migomed.backend.Repository;

import com.migomed.backend.Entity.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsRepository extends JpaRepository<Visits, Long> {
}
