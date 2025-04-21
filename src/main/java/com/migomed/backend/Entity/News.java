package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "headline", nullable = false, length = 150)
    private String headline;

    @Column(name = "publication_date", nullable = false, updatable = false)
    private LocalDateTime publicationDate = LocalDateTime.now();

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;
}
