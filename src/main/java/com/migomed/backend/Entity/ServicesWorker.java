package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "services_worker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicesWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_worker", nullable = false)
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "id_services", nullable = false)
    private Services services;
}
