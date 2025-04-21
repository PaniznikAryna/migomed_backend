package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "patronymic", length = 100)
    private String patronymic;

    @Column(name = "passport_number", nullable = false, length = 9)
    private String passportNumber;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "worker", nullable = false)
    private boolean worker = false;
}