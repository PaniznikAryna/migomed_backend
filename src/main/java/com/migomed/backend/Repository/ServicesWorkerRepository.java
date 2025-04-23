package com.migomed.backend.Repository;

import com.migomed.backend.Entity.ServicesWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesWorkerRepository extends JpaRepository<ServicesWorker, Long> {
}
