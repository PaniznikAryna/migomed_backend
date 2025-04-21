package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "analyzes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Analyzes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_worker", nullable = false)
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users users;

    @Column(name = "date_analyzes", nullable = false)
    private LocalDateTime dateAnalyzes;

    @Column(name = "result", nullable = false, columnDefinition = "TEXT")
    private String result;
}
