package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_worker", nullable = false)
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users users;

    @Column(name = "date_visit", nullable = false)
    private LocalDateTime dateVisit;

    @Column(name = "appointments", nullable = false, columnDefinition = "TEXT")
    private String appointments;
}
