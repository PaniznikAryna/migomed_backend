package com.migomed.backend.Repository;

import com.migomed.backend.Entity.Comments; // правильно, импорт своей сущности
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsReposytory extends JpaRepository<Comments, Long> {
    // Добавления сортировки комментариев можно реализовать здесь
}
