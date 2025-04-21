package com.migomed.backend.Repository;

import com.migomed.backend.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    // будут доп методы запроса
    // дописать поиск по названию
}
