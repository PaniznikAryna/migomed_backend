package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "worker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worker;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", nullable = false, unique = true)
    private Users users;

    @Column(name = "specialization", nullable = false, length = 100)
    private String specialization;

    @Column(name = "admin", nullable = false)
    private boolean admin = false;

    @Column(name = "experience", nullable = false)
    private int experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_photo", unique = true)
    private Photo photo;
}
