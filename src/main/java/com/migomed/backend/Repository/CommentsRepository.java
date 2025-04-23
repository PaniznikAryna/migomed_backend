package com.migomed.backend.Repository;

import com.migomed.backend.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    // Добавления сортировки комментариев
}
