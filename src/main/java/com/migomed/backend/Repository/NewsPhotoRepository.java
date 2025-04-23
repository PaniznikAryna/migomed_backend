package com.migomed.backend.Repository;

import com.migomed.backend.Entity.NewsPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsPhotoRepository extends JpaRepository<NewsPhoto, Long> {
}
