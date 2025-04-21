package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "photo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_path", nullable = false, length = 255)
    private String photoPath;

    @Column(name = "section", nullable = false, length = 255)
    private String section;
}
