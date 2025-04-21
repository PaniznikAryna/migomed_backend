package com.migomed.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_worker", nullable = false)
    private Worker worker;

    @Column(name = "date_day", nullable = false)
    private Date dateDay;

    @Column(name = "working_time", nullable = false, length = 11)
    private String workingTime;

    @Column(name = "vacation", nullable = false)
    private boolean vacation = false;
}
