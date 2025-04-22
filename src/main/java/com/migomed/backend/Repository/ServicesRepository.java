package com.migomed.backend.Repository;

import com.migomed.backend.Entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    //доп методы (возможно тоже поиск)
}
