package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "news_photo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_photo", nullable = false)
    private Photo photo;

    @ManyToOne
    @JoinColumn(name = "id_news", nullable = false)
    private News news;
}
